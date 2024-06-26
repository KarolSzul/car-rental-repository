package com.example.carrental.repository;

import com.example.carrental.repository.model.CarRentalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRentalModel, UUID> {
}
