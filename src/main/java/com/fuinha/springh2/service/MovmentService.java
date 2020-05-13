package com.fuinha.springh2.service;

import java.util.List;

import com.fuinha.springh2.data.entity.ManualMovment;
import com.fuinha.springh2.exception.CustomException;
import com.fuinha.springh2.web.dto.CreateMovmentDto;
import com.fuinha.springh2.web.dto.EditMovmentDto;

public interface MovmentService {
    List<ManualMovment> getAllMovments(Integer productId, Integer cosifId, Integer month, Integer year) throws CustomException;

    ManualMovment getMovment(Integer movmentId) throws CustomException;

    ManualMovment createMovment(CreateMovmentDto dto) throws CustomException;

    ManualMovment updateMovment(EditMovmentDto dto) throws CustomException;

    void deleteMovment(Integer movmentId) throws CustomException;
}