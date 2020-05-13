package com.fuinha.springh2.service;

import java.util.List;

import com.fuinha.springh2.data.entity.ManualMovement;
import com.fuinha.springh2.exception.CustomException;
import com.fuinha.springh2.web.dto.CreateMovementDto;
import com.fuinha.springh2.web.dto.EditMovementDto;

public interface MovementService {
    List<ManualMovement> getAllMovements(Integer productId, Integer cosifId, Integer month, Integer year) throws CustomException;

    ManualMovement getMovement(Integer movementId) throws CustomException;

    ManualMovement createMovement(CreateMovementDto dto) throws CustomException;

    ManualMovement updateMovement(EditMovementDto dto) throws CustomException;

    void deleteMovement(Integer movementId) throws CustomException;
}