package com.example.carrental.repository;

import com.example.carrental.repository.model.CarStatusHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarStatusHistoryRepository extends JpaRepository<CarStatusHistoryModel, UUID> {


}
