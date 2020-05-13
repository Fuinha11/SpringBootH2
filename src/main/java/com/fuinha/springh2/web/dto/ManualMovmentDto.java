package com.fuinha.springh2.web.dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import com.fuinha.springh2.data.entity.ManualMovment;

import lombok.Data;

@Data
public class ManualMovmentDto {
    private Integer id;
    private Integer month;
    private Integer year;
    private ProductDto product; 
    private ProductCosifDto productCosif;    
    private Float value;    
    private String description;    
    private String movmentDate;
    private String userCode;

    public ManualMovmentDto(ManualMovment m) {
        this.id = m.getId();
        this.month = m.getMonth();
        this.year = m.getYear();
        this.product = new ProductDto(m.getProduct());
        this.productCosif = new ProductCosifDto(m.getProductCosif());
        this.value = m.getValue();
        this.description = m.getDescription();
        this.movmentDate = m.getMovmentDate().format(DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm:ss"));
        this.userCode = m.getUserCode();
    }
}