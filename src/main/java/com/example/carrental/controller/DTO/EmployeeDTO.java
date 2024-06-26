package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.DepartmentModel;
import com.example.carrental.repository.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private Role role;
    private DepartmentModel departmentModel;





}
