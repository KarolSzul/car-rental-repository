package com.example.carrental.repository;

import com.example.carrental.model.ReservationModel;
import com.example.carrental.model.ReturnModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnRepository extends JpaRepository<ReturnModel,Long> {

    @Query("Select ReturnModel from ReturnModel r where r.customerModel.id = :id")
    public List<ReturnModel> getReturnModelByCustomerId(@Param("id") Long id);

    @Query("Select ReturnModel from ReturnModel r where r.reservationModel.id = :id")
    public ReturnModel getReturnModelByReservationId(@Param("id") Long id);



    @Query("Select ReturnModel from ReturnModel r where r.id = :id")
    public ReturnModel getReturnModelById(@Param("id") Long id);

}
