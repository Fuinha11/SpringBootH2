package com.fuinha.springh2.web.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fuinha.springh2.data.entity.Product;
import com.fuinha.springh2.data.entity.ProductStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String description;
    private ProductStatus status;
    private List<ProductCosifDto> cosifList;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.status = product.getStatus();
        if (Objects.nonNull(product.getCosifs()))
            this.cosifList = product
                                .getCosifs()
                                .stream()
                                .map(pc -> new ProductCosifDto(pc))
                                .collect(Collectors.toList());
        }
}