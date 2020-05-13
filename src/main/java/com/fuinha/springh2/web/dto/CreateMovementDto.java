package com.fuinha.springh2.web.dto;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMovementDto {
    @NonNull
    private Integer month;
    @NonNull
    private Integer year;
    @NonNull
    private Integer productId;
    @NonNull
    private Integer cosifId;
    private Float value;
    private String description;
    private String userCode;
}