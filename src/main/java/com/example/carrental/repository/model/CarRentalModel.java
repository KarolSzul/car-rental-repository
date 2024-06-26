package com.example.carrental.repository.model;

import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarRentalModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String name;

    @Column
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String domain;

    @Column
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 200, message = "{validation.name.size.too_long}")
    private String address;

    @Column
    @OneToMany
    private List<EmployeeModel> employeeModelList;

    @Column
    private String logotype;

    @OneToMany(mappedBy = "carRentalModel")
    private List<CarModel> carModelList;


    @OneToMany(mappedBy = "carRentalModel")
    private Set<CustomerModel> customerModelSet;

    @OneToMany (mappedBy = "carRentalModel")
    private Set<DepartmentModel> departmentModelSet;

}