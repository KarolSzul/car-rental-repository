package com.example.carrental.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "first_name")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String lastName;

    @Column(name = "is_manager")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel departmentModel;
}
