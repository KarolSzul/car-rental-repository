package com.example.carrental.repository.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Column(unique = true)
    @Size(min = 3, message = "{validation.name.size.too_short}")
    @Size(max = 5, message = "{validation.name.size.too_long}")
    private String alias;

    @Column
    private City city;

    @Column(name = "street")
    @Size(max = 150, message = "{validation.name.size.too_long}")
    private String street;

    @OneToMany(mappedBy = "departmentModel")
    private Set<EmployeeModel> employeeModels;

    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRentalModel carRentalModel;
}

