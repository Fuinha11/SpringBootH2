package com.fuinha.springh2.web.dto;

import com.fuinha.springh2.data.entity.ProductCosif;
import com.fuinha.springh2.data.entity.ProductStatus;

import lombok.Data;

@Data
public class ProductCosifDto {
    private Integer id;
    private Integer productId;
    private String classification;
    private ProductStatus status;

    public ProductCosifDto(ProductCosif pc) {
        this.id = pc.getId();
        this.productId = pc.getProduct().getId();
        this.classification = pc.getClassification();
        this.status = pc.getStatus();
    }
}