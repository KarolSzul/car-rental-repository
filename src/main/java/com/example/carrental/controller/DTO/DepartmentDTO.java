package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.CarRentalModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {


    private String departmentAddress;
    private CarRentalModel carRentalModel;


}
