package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.EmployeeModel;
import com.example.carrental.repository.model.ReservationModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDTO {


    private EmployeeModel employeeModel;
    private LocalDate returnDate;
    private ReservationModel reservationModel;
    private Integer extraCharge;
    private String comments;

}
