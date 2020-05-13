package com.fuinha.springh2.data.repository;

import java.util.List;

import com.fuinha.springh2.data.entity.Product;
import com.fuinha.springh2.data.entity.ProductCosif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCosifRepository extends JpaRepository<ProductCosif, Integer> {
    List<ProductCosif> findAllByProduct(Product product);
}