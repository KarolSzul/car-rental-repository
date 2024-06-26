package com.example.carrental.repository;

import com.example.carrental.repository.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, UUID> {

    @Query("Select ReservationModel from ReservationModel r where r.customerModel.id = :id")
    public List<ReservationModel> getReservationModelByCustomerId(@Param("id") UUID id);




}
