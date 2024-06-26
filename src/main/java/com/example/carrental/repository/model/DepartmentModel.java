package com.example.carrental.repository.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "department_address")
    @Size(max = 150, message = "{validation.name.size.too_long}")
    private String departmentAddress;

    @OneToMany(mappedBy = "departmentModel")
    private Set<EmployeeModel> employeeModels;

    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRentalModel carRentalModel;
}

