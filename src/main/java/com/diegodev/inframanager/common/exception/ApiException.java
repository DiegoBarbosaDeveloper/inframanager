package com.diegodev.inframanager.common.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{
    private final HttpStatus status;

    public ApiException(HttpStatus status, String massage){
        super(massage);
        this.status = status;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
