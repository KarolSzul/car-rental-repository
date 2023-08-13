package com.example.carrental.service;

import com.example.carrental.model.CarModel;
import com.example.carrental.model.ReservationModel;
import com.example.carrental.model.ReturnModel;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.repository.ReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class BillingService {

    private final ReservationRepository reservationRepository;
    private final ReturnRepository returnRepository;

    public Double getInitialCost(CarModel carModel, LocalDate startDay, LocalDate endDate) {
        double numberOfDays = (double) ChronoUnit.DAYS.between(endDate, startDay);
        return carModel.getPricePerDay() * numberOfDays;
    }

    public Double getFinalCost(Long id) {
        ReservationModel reservationModel = reservationRepository.getReservationModelById(id);
        ReturnModel returnModel = returnRepository.getReturnModelByReservationId(id);

        Double totalCost = reservationModel.getPrice() + returnModel.getExtraCharge();
        return totalCost;
    }



}
