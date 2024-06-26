package com.example.carrental.repository;

import com.example.carrental.repository.model.ReturnModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReturnRepository extends JpaRepository<ReturnModel, UUID> {

    @Query("Select ReturnModel from ReturnModel r where r.customerModel.id = :id")
    public List<ReturnModel> getReturnModelByCustomerId(@Param("id") UUID id);

    @Query("Select ReturnModel from ReturnModel r where r.reservationModel.id = :id")
    public ReturnModel getReturnModelByReservationId(@Param("id") UUID id);


    @Query("Select ReturnModel from ReturnModel r where r.id = :id")
    public ReturnModel getReturnModelById(@Param("id") UUID id);

}
