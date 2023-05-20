package com.example.carrental.repository;

import com.example.carrental.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModel, Long> {

}