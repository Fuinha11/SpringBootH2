package com.fuinha.springh2.web.dto;

import java.time.format.DateTimeFormatter;

import com.fuinha.springh2.data.entity.ManualMovement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManualMovementDto {
    private Integer id;
    private Integer month;
    private Integer year;
    private ProductDto product;
    private ProductCosifDto productCosif;
    private Float value;
    private String description;
    private String movementDate;
    private String userCode;

    public ManualMovementDto(ManualMovement m) {
        this.id = m.getId();
        this.month = m.getMonth();
        this.year = m.getYear();
        this.product = new ProductDto(m.getProduct(), false);
        this.productCosif = new ProductCosifDto(m.getProductCosif());
        this.value = m.getValue();
        this.description = m.getDescription();
        this.movementDate = m.getMovementDate().format(DateTimeFormatter.ISO_DATE_TIME);
        this.userCode = m.getUserCode();
    }
}