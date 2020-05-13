package com.fuinha.springh2.exception;

import org.springframework.http.HttpStatus;

public class NullBodyException extends CustomException {

    public NullBodyException() {
        super(HttpStatus.BAD_REQUEST, 401, "The request body cannot be null");
    }

}