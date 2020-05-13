package com.fuinha.springh2.web;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fuinha.springh2.data.entity.ManualMovment;
import com.fuinha.springh2.exception.NullBodyException;
import com.fuinha.springh2.service.MovmentService;
import com.fuinha.springh2.web.dto.BaseResponse;
import com.fuinha.springh2.web.dto.CreateMovmentDto;
import com.fuinha.springh2.web.dto.EditMovmentDto;
import com.fuinha.springh2.web.dto.ManualMovmentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovmentController {

    @Autowired
    private MovmentService service;

    @GetMapping("/movments")
    public ResponseEntity<BaseResponse<List<ManualMovmentDto>>> getAllMovments(
            @RequestParam(required = false) Integer productId, @RequestParam(required = false) Integer cosifId,
            @RequestParam(required = false) Integer month, @RequestParam(required = false) Integer year) {
        try {
            List<ManualMovment> allProducts = service.getAllMovments(productId, cosifId, month, year);
            return new BaseResponse<>(
                    allProducts.stream().map(p -> new ManualMovmentDto(p)).collect(Collectors.toList())).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @GetMapping("/movment/{id}")
    public ResponseEntity<BaseResponse<ManualMovmentDto>> getMovment(@PathVariable(name = "id") Integer id) {
        try {
            ManualMovment movment = service.getMovment(id);
            return new BaseResponse<>(new ManualMovmentDto(movment)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @PutMapping("/movment/{id}")
    public ResponseEntity<BaseResponse<ManualMovmentDto>> updateMovment(@PathVariable(name = "id") Integer id,
            @RequestBody EditMovmentDto dto) {
        try {
            if (Objects.isNull(dto))
                throw new NullBodyException();
            dto.setId(id);
            ManualMovment movment = service.updateMovment(dto);
            return new BaseResponse<>(new ManualMovmentDto(movment)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @PostMapping("/movments")
    public ResponseEntity<BaseResponse<ManualMovmentDto>> createMovment(@RequestBody CreateMovmentDto dto) {
        try {
            if (Objects.isNull(dto))
                throw new NullBodyException();
            ManualMovment movment = service.createMovment(dto);
            return new BaseResponse<>(new ManualMovmentDto(movment)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @DeleteMapping("/movment/{id}")
    public ResponseEntity<BaseResponse> deleteMovment(@PathVariable(name = "id") Integer id) {
        try {
            service.deleteMovment(id);
            return new BaseResponse(null).deleted();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

}