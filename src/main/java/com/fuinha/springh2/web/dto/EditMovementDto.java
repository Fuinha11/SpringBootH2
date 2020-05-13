package com.fuinha.springh2.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditMovementDto {
    private Integer id;
    private Float value;
    private String description;
    private String userCode;
}