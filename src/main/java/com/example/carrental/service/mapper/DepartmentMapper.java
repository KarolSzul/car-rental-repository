package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.DepartmentDTO;
import com.example.carrental.repository.model.DepartmentModel;
import org.springframework.stereotype.Component;


@Component
public class DepartmentMapper {

    public DepartmentModel departmentDTOToDepartmentModel(DepartmentDTO departmentDTO, DepartmentModel departmentModel){
        if (departmentDTO.getCity() != null){
            departmentModel.setCity(departmentDTO.getCity());
        }
        if (departmentDTO.getStreet() != null) {
            departmentModel.setStreet(departmentDTO.getStreet());
        }
        if (departmentDTO.getAlias() != null) {
            departmentModel.setAlias(departmentDTO.getAlias());
        }
        if (departmentDTO.getEmployeeModels() != null) {
            departmentModel.setEmployeeModels(departmentDTO.getEmployeeModels());
        }
        if (departmentDTO.getCarRentalModel() != null){
            departmentModel.setCarRentalModel(departmentDTO.getCarRentalModel());
        }

        return departmentModel;

    }

    public DepartmentDTO departmentModelToDepartmentDTO(DepartmentModel departmentModel) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setStreet(departmentModel.getStreet());
        departmentDTO.setCity(departmentModel.getCity());
        departmentDTO.setAlias(departmentModel.getAlias());
        departmentDTO.setCarRentalModel(departmentModel.getCarRentalModel());
        departmentDTO.setEmployeeModels(departmentModel.getEmployeeModels());
        return departmentDTO;
    }


}
