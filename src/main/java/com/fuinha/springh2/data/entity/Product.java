package com.fuinha.springh2.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
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

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ProductCosif> cosifs;
}