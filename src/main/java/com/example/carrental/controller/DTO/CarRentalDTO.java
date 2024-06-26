package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.CarModel;
import com.example.carrental.repository.model.CustomerModel;
import com.example.carrental.repository.model.DepartmentModel;
import com.example.carrental.repository.model.EmployeeModel;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarRentalDTO {

    private String name;

    private String domain;

    private String address;

    private List<EmployeeModel> employeeModelList;

    private List<CarModel> carModelList;

    private Set<CustomerModel> customerModelSet;

    private Set<DepartmentModel> departmentModelSet;

    private String logotype;

}
