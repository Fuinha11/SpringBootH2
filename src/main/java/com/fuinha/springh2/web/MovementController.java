package com.fuinha.springh2.web;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fuinha.springh2.data.entity.ManualMovement;
import com.fuinha.springh2.exception.NullBodyException;
import com.fuinha.springh2.service.MovementService;
import com.fuinha.springh2.web.dto.BaseResponse;
import com.fuinha.springh2.web.dto.CreateMovementDto;
import com.fuinha.springh2.web.dto.EditMovementDto;
import com.fuinha.springh2.web.dto.ManualMovementDto;

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
public class MovementController {

    @Autowired
    private MovementService service;

    @GetMapping("/movements")
    public ResponseEntity<BaseResponse<List<ManualMovementDto>>> getAllMovements(
            @RequestParam(required = false) Integer productId, @RequestParam(required = false) Integer cosifId,
            @RequestParam(required = false) Integer month, @RequestParam(required = false) Integer year) {
        try {
            List<ManualMovement> allProducts = service.getAllMovements(productId, cosifId, month, year);
            return new BaseResponse<>(
                    allProducts.stream().map(p -> new ManualMovementDto(p)).collect(Collectors.toList())).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @GetMapping("/month/{month}/year/{year}/movement/{number}")
    public ResponseEntity<BaseResponse<ManualMovementDto>> getMovement(@PathVariable(name = "month") Integer month,
            @PathVariable(name = "year") Integer year, @PathVariable(name = "number") Integer number) {
        try {
            ManualMovement movement = service.getMovement(month, year, number);
            return new BaseResponse<>(new ManualMovementDto(movement)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @PutMapping("/month/{month}/year/{year}/movement/{number}")
    public ResponseEntity<BaseResponse<ManualMovementDto>> updateMovement(@PathVariable(name = "month") Integer month,
            @PathVariable(name = "year") Integer year, @PathVariable(name = "number") Integer number,
            @RequestBody EditMovementDto dto) {
        try {
            if (Objects.isNull(dto))
                throw new NullBodyException();
            dto.setMonth(month);
            dto.setYear(year);
            dto.setNumber(number);
            ManualMovement movement = service.updateMovement(dto);
            return new BaseResponse<>(new ManualMovementDto(movement)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @PostMapping("/movements")
    public ResponseEntity<BaseResponse<ManualMovementDto>> createMovement(@RequestBody CreateMovementDto dto) {
        try {
            if (Objects.isNull(dto))
                throw new NullBodyException();
            ManualMovement movement = service.createMovement(dto);
            return new BaseResponse<>(new ManualMovementDto(movement)).ok();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

    @DeleteMapping("/month/{month}/year/{year}/movement/{number}")
    public ResponseEntity<BaseResponse> deleteMovement(@PathVariable(name = "month") Integer month,
            @PathVariable(name = "year") Integer year, @PathVariable(name = "number") Integer number) {
        try {
            service.deleteMovement(month, year, number);
            return new BaseResponse(null).deleted();
        } catch (Exception e) {
            return new BaseResponse(e).error();
        }
    }

}