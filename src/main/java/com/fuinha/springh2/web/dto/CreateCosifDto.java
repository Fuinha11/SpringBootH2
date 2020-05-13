package com.fuinha.springh2.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCosifDto {
    private Integer productId;
    private String classification;
}