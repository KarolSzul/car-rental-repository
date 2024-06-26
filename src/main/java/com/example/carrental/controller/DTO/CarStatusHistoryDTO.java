package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.CarModel;
import com.example.carrental.repository.model.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarStatusHistoryDTO {


    private LocalDate startDate;
    private LocalDate endDate;
    private CarStatus carStatus;
    private CarModel carModel;

}
