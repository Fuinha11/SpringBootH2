package com.fuinha.springh2.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends CustomException {

    public EntityNotFoundException(Class entity, String key) {
        super(HttpStatus.NOT_FOUND, 404, "No " + entity.getSimpleName() + " found for key: " + key);
    }
}