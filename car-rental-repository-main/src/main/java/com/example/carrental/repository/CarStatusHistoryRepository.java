package com.example.carrental.repository;

import com.example.carrental.model.CarStatusHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarStatusHistoryRepository extends JpaRepository<CarStatusHistoryModel, Long> {
}
