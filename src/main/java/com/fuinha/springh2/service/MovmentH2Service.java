package com.fuinha.springh2.service;

import java.util.List;
import java.util.Objects;

import com.fuinha.springh2.data.entity.ManualMovment;
import com.fuinha.springh2.data.repository.ManualMovmentRepository;
import com.fuinha.springh2.exception.CustomException;
import com.fuinha.springh2.exception.EntityNotFoundException;
import com.fuinha.springh2.web.dto.CreateMovmentDto;
import com.fuinha.springh2.web.dto.EditMovmentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class MovmentH2Service implements MovmentService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ManualMovmentRepository movmentRepository;

    @Override
    public List<ManualMovment> getAllMovments(Integer productId, Integer cosifId, Integer month, Integer year)
            throws CustomException {
        ManualMovment example = new ManualMovment();
        if (Objects.nonNull(productId))
            example.setProduct(productService.getProduct(productId));
        if (Objects.nonNull(cosifId))
            example.setProductCosif(productService.getCosif(cosifId));
        example.setMonth(month);
        example.setYear(year);
        return movmentRepository.findAll(Example.of(example));
    }

    @Override
    public ManualMovment getMovment(Integer movmentId) throws CustomException {
        ManualMovment movment = movmentRepository.findById(movmentId).orElse(null);
        if (Objects.isNull(movment))
            throw new EntityNotFoundException(ManualMovment.class, movmentId.toString());
        return movment;
    }

    @Override
    public ManualMovment createMovment(CreateMovmentDto dto) throws CustomException {
        ManualMovment movment = new ManualMovment();
        movment.setProduct(productService.getProduct(dto.getProductId()));
        movment.setProductCosif(productService.getCosif(dto.getCosifId()));
        movment.setMonth(dto.getMonth());
        movment.setYear(dto.getYear());
        movment.setValue(dto.getValue());
        movment.setDescription(dto.getDescription());
        movment.setMovmentDate(dto.getMovmentDate());
        movment.setUserCode(dto.getUserCode());
        return movmentRepository.save(movment);
    }

    @Override
    public ManualMovment updateMovment(EditMovmentDto dto) throws CustomException {
        ManualMovment movment = getMovment(dto.getId());
        movment.setValue(dto.getValue());
        movment.setDescription(dto.getDescription());
        movment.setUserCode(dto.getUserCode());
        return movmentRepository.save(movment);
    }

    @Override
    public void deleteMovment(Integer movmentId) throws CustomException {
        ManualMovment movment = getMovment(movmentId);
        movmentRepository.delete(movment);
    }
}