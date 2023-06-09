package com.example.carrental.DTO;

import com.example.carrental.model.CarModel;
import com.example.carrental.model.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CarStatusHistoryDTO {


    private LocalDate startDate;
    private LocalDate endDate;
    private CarStatus carStatus;
    private CarModel carModel;

}
