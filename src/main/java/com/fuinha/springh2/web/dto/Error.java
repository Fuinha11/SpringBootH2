package com.fuinha.springh2.web.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Error implements Serializable {
    private final int code;
    private final String message;    
}