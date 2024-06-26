package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.EmployeeDTO;
import com.example.carrental.repository.model.EmployeeModel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeModel employeeDTOTOEmployeeModel(EmployeeDTO employeeDTO, EmployeeModel employeeModel){
        if (employeeDTO.getFirstName() != null){
            employeeModel.setFirstName(employeeDTO.getFirstName());
        }
        if (employeeDTO.getLastName() != null){
            employeeModel.setLastName(employeeDTO.getLastName());
        }
        if (employeeDTO.getDepartmentModel() != null){
            employeeModel.setDepartmentModel(employeeDTO.getDepartmentModel());
        }
        if (employeeDTO.getRole() != null) {
            employeeModel.setRole(employeeDTO.getRole());
        }

        return employeeModel;
    }

    public EmployeeDTO employeeModelToEmployeeDTO(EmployeeModel employeeModel) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDepartmentModel(employeeModel.getDepartmentModel());
        employeeDTO.setRole(employeeModel.getRole());
        employeeDTO.setFirstName(employeeModel.getFirstName());
        employeeDTO.setLastName(employeeModel.getFirstName());
        return employeeDTO;

    }


}
