package com.example.carrental.repository;

import com.example.carrental.model.ReturnModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepository extends JpaRepository<ReturnModel, Long> {
}
