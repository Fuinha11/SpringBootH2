package com.fuinha.springh2.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MOVIMENTO_MANUAL")
@IdClass(MovementKey.class)
public class ManualMovement {
    @Id
    @Column(name = "NUM_LANCAMENTO")
    private Integer number;

    @Id
    @Column(name = "DAT_MES")
    private Integer month;

    @Id
    @Column(name = "DAT_ANO")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "COD_PRODUTO")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "COD_COSIF")
    private ProductCosif productCosif;

    @Column(name = "VAL_VALOR")
    private Float value;

    @Column(name = "DES_DESCRICAO")
    private String description;

    @Column(name = "DAT_MOVIMENTO")
    private LocalDateTime movementDate;

    @Column(name = "COD_USUARIO")
    private String userCode;
}