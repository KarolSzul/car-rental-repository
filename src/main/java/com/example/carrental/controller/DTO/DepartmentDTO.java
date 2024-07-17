package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.CarRentalModel;
import com.example.carrental.repository.model.City;
import com.example.carrental.repository.model.EmployeeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {


    private String alias;
    private City city;
    private String street;
    private Set<EmployeeModel> employeeModels;
    private CarRentalModel carRentalModel;


}
