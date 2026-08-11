package com.diegodev.inframanager.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    @Builder.Default
    private OffsetDateTime timestamp = OffsetDateTime.now();

    private boolean success;
    private String massage;
    private T data;
    private List<String> errors;


    public static <T> ApiResponse<T> success(T data){
        return ApiResponse.<T>builder()
                .success(true)

                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> error(String massage, List<String> errors){
        return ApiResponse.<T>builder()
                .success(false)
                .massage(massage)
                .errors(errors)
                .build();
    }


}
