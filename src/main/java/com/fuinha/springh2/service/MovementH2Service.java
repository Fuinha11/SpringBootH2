package com.fuinha.springh2.service;

import java.util.List;
import java.util.Objects;

import com.fuinha.springh2.data.entity.ManualMovement;
import com.fuinha.springh2.data.repository.ManualMovementRepository;
import com.fuinha.springh2.exception.CustomException;
import com.fuinha.springh2.exception.EntityNotFoundException;
import com.fuinha.springh2.web.dto.CreateMovementDto;
import com.fuinha.springh2.web.dto.EditMovementDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class MovementH2Service implements MovementService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ManualMovementRepository movementRepository;

    @Override
    public List<ManualMovement> getAllMovements(Integer productId, Integer cosifId, Integer month, Integer year)
            throws CustomException {
        ManualMovement example = new ManualMovement();
        if (Objects.nonNull(productId))
            example.setProduct(productService.getProduct(productId));
        if (Objects.nonNull(cosifId))
            example.setProductCosif(productService.getCosif(cosifId));
        example.setMonth(month);
        example.setYear(year);
        return movementRepository.findAll(Example.of(example));
    }

    @Override
    public ManualMovement getMovement(Integer movementId) throws CustomException {
        ManualMovement movement = movementRepository.findById(movementId).orElse(null);
        if (Objects.isNull(movement))
            throw new EntityNotFoundException(ManualMovement.class, movementId.toString());
        return movement;
    }

    @Override
    public ManualMovement createMovement(CreateMovementDto dto) throws CustomException {
        ManualMovement movement = new ManualMovement();
        movement.setProduct(productService.getProduct(dto.getProductId()));
        movement.setProductCosif(productService.getCosif(dto.getCosifId()));
        movement.setMonth(dto.getMonth());
        movement.setYear(dto.getYear());
        movement.setValue(dto.getValue());
        movement.setDescription(dto.getDescription());
        movement.setMovementDate(dto.getMovementDate());
        movement.setUserCode(dto.getUserCode());
        return movementRepository.save(movement);
    }

    @Override
    public ManualMovement updateMovement(EditMovementDto dto) throws CustomException {
        ManualMovement movement = getMovement(dto.getId());
        movement.setValue(dto.getValue());
        movement.setDescription(dto.getDescription());
        movement.setUserCode(dto.getUserCode());
        return movementRepository.save(movement);
    }

    @Override
    public void deleteMovement(Integer movementId) throws CustomException {
        ManualMovement movement = getMovement(movementId);
        movementRepository.delete(movement);
    }
}