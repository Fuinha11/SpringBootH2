package com.fuinha.springh2.web.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Error {
    private final int code;
    private final String message;    
}