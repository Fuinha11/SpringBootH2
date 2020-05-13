package com.fuinha.springh2.web;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fuinha.springh2.data.entity.Product;
import com.fuinha.springh2.data.entity.ProductCosif;
import com.fuinha.springh2.exception.NullBodyException;
import com.fuinha.springh2.service.ProductService;
import com.fuinha.springh2.web.dto.BaseResponse;
import com.fuinha.springh2.web.dto.CreateProductDto;
import com.fuinha.springh2.web.dto.ProductCosifDto;
import com.fuinha.springh2.web.dto.ProductDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControler {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<BaseResponse<List<ProductDto>>> getAllProducts() {
        try {
            List<Product> allProducts = service.getAllProducts();
            return new BaseResponse<>(allProducts.stream().map(p -> new ProductDto(p)).collect(Collectors.toList()))
                    .ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<BaseResponse<ProductDto>> getProduct(@PathVariable(name = "id") Integer id) {
        try {
            Product product = service.getProduct(id);
            return new BaseResponse<>(new ProductDto(product)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<BaseResponse<ProductDto>> updateProduct(@PathVariable(name = "id") Integer id,
            @RequestBody ProductDto dto) {
        try {
            if (Objects.isNull(dto))
                throw new NullBodyException();
            dto.setId(id);
            Product product = service.updateProduct(dto);
            return new BaseResponse<>(new ProductDto(product)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<BaseResponse<ProductDto>> createProduct(@RequestBody CreateProductDto dto) {
        try {
            if (Objects.isNull(dto))
                throw new NullBodyException();
            Product product = service.createProduct(dto);
            return new BaseResponse<>(new ProductDto(product)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<BaseResponse> deleteProduct(@PathVariable(name = "id") Integer id) {
        try {
            service.deleteProduct(id);
            return new BaseResponse(null).deleted();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @GetMapping("/product/{id}/cosifs")
    public ResponseEntity<BaseResponse<List<ProductCosifDto>>> getAllCosifs(@PathVariable(name = "id") Integer id) {
        try {
            List<ProductCosif> allProducts = service.getAllCosifsByProductId(id);
            return new BaseResponse<List<ProductCosifDto>>(
                    allProducts.stream().map(p -> new ProductCosifDto(p)).collect(Collectors.toList())).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

}