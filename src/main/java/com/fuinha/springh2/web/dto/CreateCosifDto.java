package com.fuinha.springh2.web.dto;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCosifDto {
    @NonNull
    private Integer productId;
    private String classification;
}