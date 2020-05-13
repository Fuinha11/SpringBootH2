package com.fuinha.springh2.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public abstract class CustomException extends Exception {
    private HttpStatus status;
    private Integer code;
    private String message;

    public CustomException(HttpStatus status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}