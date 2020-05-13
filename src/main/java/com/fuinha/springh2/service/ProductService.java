package com.fuinha.springh2.service;

import java.util.List;

import com.fuinha.springh2.data.entity.Product;
import com.fuinha.springh2.data.entity.ProductCosif;
import com.fuinha.springh2.exception.CustomException;
import com.fuinha.springh2.web.dto.CreateCosifDto;
import com.fuinha.springh2.web.dto.CreateProductDto;
import com.fuinha.springh2.web.dto.ProductCosifDto;
import com.fuinha.springh2.web.dto.ProductDto;

public interface ProductService {
    List<Product> getAllProducts() throws CustomException;

    Product getProduct(Integer id) throws CustomException;

    Product createProduct(CreateProductDto dto) throws CustomException;

    Product updateProduct(ProductDto dto) throws CustomException;

    void deleteProduct(Integer id) throws CustomException;

    List<ProductCosif> getAllCosifsByProductId(Integer id) throws CustomException;

    ProductCosif getCosif(Integer id) throws CustomException;

    ProductCosif createCosif(CreateCosifDto dto) throws CustomException;

    ProductCosif updateCosif(ProductCosifDto dto) throws CustomException;

    void deleteCosif(Integer id) throws CustomException;
}