package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.DepartmentDTO;
import com.example.carrental.repository.model.DepartmentModel;
import org.springframework.stereotype.Component;


@Component
public class DepartmentMapper {

    public DepartmentModel departmentDTOToDepartmentModel(DepartmentDTO departmentDTO, DepartmentModel departmentModel){
        if (departmentDTO.getDepartmentAddress() != null){
            departmentModel.setDepartmentAddress(departmentDTO.getDepartmentAddress());
        }
        if (departmentDTO.getCarRentalModel() != null){
            departmentModel.setCarRentalModel(departmentDTO.getCarRentalModel());
        }

        return departmentModel;

    }

    public DepartmentDTO departmentModelToDepartmentDTO(DepartmentModel departmentModel) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentAddress(departmentModel.getDepartmentAddress());
        departmentDTO.setCarRentalModel(departmentModel.getCarRentalModel());
        return departmentDTO;
    }


}
