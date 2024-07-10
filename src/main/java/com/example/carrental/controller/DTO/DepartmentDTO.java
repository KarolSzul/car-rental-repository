package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.CarRentalModel;
import com.example.carrental.repository.model.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {


    private City city;
    private String alias;
    private String street;
    private CarRentalModel carRentalModel;


}
