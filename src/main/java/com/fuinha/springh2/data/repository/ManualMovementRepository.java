package com.fuinha.springh2.data.repository;

import com.fuinha.springh2.data.entity.ManualMovement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManualMovementRepository extends JpaRepository<ManualMovement, Integer> {

}