package com.example.carrental.service;

import com.example.carrental.controller.DTO.CarDTO;
import com.example.carrental.repository.model.CarModel;
import com.example.carrental.repository.model.ReservationModel;
import com.example.carrental.repository.model.ReturnModel;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.repository.ReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillingService {

    private final ReservationRepository reservationRepository;
    private final ReturnRepository returnRepository;

    public Double getInitialCost(CarDTO carDTO, LocalDate startDay, LocalDate endDate) {
        double numberOfDays = (double) ChronoUnit.DAYS.between(endDate, startDay);
        return carDTO.getPricePerDay() * numberOfDays;
    }

    public Double getFinalCost(UUID id) {
        ReservationModel reservationModel = reservationRepository.findById(id).orElse(null);
        ReturnModel returnModel = returnRepository.getReturnModelByReservationId(id);
        Double totalCost = reservationModel.getPrice() + returnModel.getExtraCharge();
        return totalCost;
    }



}
