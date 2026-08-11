package com.diegodev.inframanager.common.exception;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Void>> handleApiException(@NonNull ApiException exception){
        return ResponseEntity.status(exception.getStatus())
                .body(ApiResponse.error(exception.getMessage(), List.of(exception.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(@NonNull MethodArgumentNotValidException exception){
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return ResponseEntity.badRequest().body(ApiResponse.error(
                "Validation failed", errors
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneric(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Unexpected error", List.of(exception.getMessage())));
    }
}
