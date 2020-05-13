package com.fuinha.springh2.web;

import com.fuinha.springh2.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControler {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String test() {
        return "";
    }
    
}