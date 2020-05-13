package com.fuinha.springh2.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditMovementDto {
    private Integer month;
    private Integer year;
    private Integer number;
    private Float value;
    private String description;
    private String userCode;
}