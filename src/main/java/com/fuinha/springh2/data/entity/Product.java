package com.fuinha.springh2.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "PRODUTO")
public class Product {

	@Id
    @Column(name = "COD_PRODUTO")
    @GeneratedValue
    private Integer id;
    
    @Column(name = "DES_PRODUTO", nullable = true)
    private String description;
    
    @Column(name = "STA_STATUS", nullable = true)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
}