package com.fuinha.springh2.web.dto;

import lombok.Data;

@Data
public class Error {
    private final int code;
    private final String message;
}