package com.fuinha.springh2.web;

import java.time.LocalDateTime;

import com.fuinha.springh2.data.entity.Product;
import com.fuinha.springh2.data.entity.ProductCosif;
import com.fuinha.springh2.service.MovementService;
import com.fuinha.springh2.service.ProductService;
import com.fuinha.springh2.web.dto.BaseResponse;
import com.fuinha.springh2.web.dto.CreateCosifDto;
import com.fuinha.springh2.web.dto.CreateMovementDto;
import com.fuinha.springh2.web.dto.CreateProductDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PopulateController {

    /*
     * This Class exists only to prompt a way for a user to populate the database
     * since it resets every time the application is lauched.
     */

    @Autowired
    private ProductService productService;
    @Autowired
    private MovementService movementService;

    @GetMapping("/populate")
    public ResponseEntity<BaseResponse<String>> populateDb() {
        try {
            for (int i = 0; i < 3; i++) {
                Product p = productService.createProduct(new CreateProductDto("Product" + i));
                for (int j = 0; j < 3; j++) {
                    ProductCosif c = productService
                            .createCosif(new CreateCosifDto(p.getId(), "classification" + i + j));
                    for (int k = 0; k < 2; k++) {
                        LocalDateTime date = LocalDateTime.now();
                        movementService.createMovement(
                                new CreateMovementDto(date.getMonthValue(), date.getYear(), p.getId(), c.getId(),
                                        Float.valueOf(i * j * k), "description" + i + j + k, "userCode" + i + j + k));
                    }
                }
            }
            return new BaseResponse<>("Database populated").ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

}