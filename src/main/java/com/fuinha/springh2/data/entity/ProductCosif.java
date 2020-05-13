package com.fuinha.springh2.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUTO_COSIF")
public class ProductCosif {

    @Id
    @Column(name = "COD_COSIF")
    @GeneratedValue
    private Integer id;     

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO")
    private Product product;    
    
    @Column(name = "COD_CLASSIFICACAO", nullable = true)
    private String classification; 
    
    @Column(name = "STA_STATUS", nullable = true)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;   
}