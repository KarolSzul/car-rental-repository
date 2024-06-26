package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.CarModel;
import com.example.carrental.repository.model.CustomerModel;
import com.example.carrental.repository.model.DepartmentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

    private LocalDate reservationBookingDate;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private CustomerModel customerModel;
    private CarModel carModel;
    private DepartmentModel startDepartmentModel;
    private DepartmentModel destinationDepartmentModel;
    private Double price;



}
