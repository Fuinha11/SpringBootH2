package com.fuinha.springh2.web.dto;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMovmentDto {
    @NonNull
    private Integer month;
    @NonNull
    private Integer year;
    @NonNull
    private Integer productId;
    @NonNull
    private Integer cosifId;
    @NonNull
    private LocalDateTime movmentDate;
    private Float value;
    private String description;
    private String userCode;
}