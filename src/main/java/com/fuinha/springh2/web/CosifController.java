package com.fuinha.springh2.web;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fuinha.springh2.data.entity.ProductCosif;
import com.fuinha.springh2.exception.NullBodyException;
import com.fuinha.springh2.service.ProductService;
import com.fuinha.springh2.web.dto.BaseResponse;
import com.fuinha.springh2.web.dto.CreateCosifDto;
import com.fuinha.springh2.web.dto.ProductCosifDto;

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
public class CosifController {

    @Autowired
    private ProductService service;

    @GetMapping("/product/{productId}/cosifs")
    public ResponseEntity<BaseResponse<List<ProductCosifDto>>> getAllCosifsForProduct(
            @PathVariable(name = "productId") Integer productId) {
        try {
            List<ProductCosif> allProducts = service.getAllCosifsByProductId(productId);
            return new BaseResponse<List<ProductCosifDto>>(
                    allProducts.stream().map(p -> new ProductCosifDto(p)).collect(Collectors.toList())).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @GetMapping("/cosif/{cosifId}")
    public ResponseEntity<BaseResponse<ProductCosifDto>> getCosif(@PathVariable(name = "cosifId") Integer cosifId) {
        try {
            ProductCosif cosif = service.getCosif(cosifId);
            return new BaseResponse<ProductCosifDto>(new ProductCosifDto(cosif)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @PutMapping("/cosif/{cosifId}")
    public ResponseEntity<BaseResponse<ProductCosifDto>> updateCosif(@PathVariable(name = "cosifId") Integer cosifId,
            @RequestBody ProductCosifDto dto) {
        try {
            if (Objects.isNull(dto))
                throw new NullBodyException();
            dto.setId(cosifId);
            ProductCosif cosif = service.updateCosif(dto);
            return new BaseResponse<>(new ProductCosifDto(cosif)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @PostMapping("/cosifs")
    public ResponseEntity<BaseResponse<ProductCosifDto>> createCosif(@RequestBody CreateCosifDto dto) {
        try {
            if (Objects.isNull(dto))
                throw new NullBodyException();
            ProductCosif cosif = service.createCosif(dto);
            return new BaseResponse<>(new ProductCosifDto(cosif)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @DeleteMapping("/cosif/{cosifId}")
    public ResponseEntity<BaseResponse> deleteCosif(@PathVariable(name = "cosifId") Integer cosifId) {
        try {
            service.deleteProduct(cosifId);
            return new BaseResponse(null).deleted();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }
}