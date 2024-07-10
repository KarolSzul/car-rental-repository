package com.example.carrental.repository;

import com.example.carrental.repository.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, UUID> {

    @Query("Select DepartmentModel from DepartmentModel d where d.alias = :alias")
    public DepartmentModel getByAlias (@Param("alias") String alias);

}
