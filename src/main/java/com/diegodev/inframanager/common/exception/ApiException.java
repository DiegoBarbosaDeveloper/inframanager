package com.diegodev.inframanager.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends RuntimeException{
    private final HttpStatus status;

    public ApiException(HttpStatus status, String massage){
        super(massage);
        this.status = status;
    }

}
