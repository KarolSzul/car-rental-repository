package com.example.carrental.service;

import com.example.carrental.controller.DTO.DepartmentDTO;
import com.example.carrental.service.mapper.DepartmentMapper;
import com.example.carrental.repository.model.DepartmentModel;
import com.example.carrental.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;


    public List<DepartmentDTO> getAllDepartments(){
        return departmentRepository
                .findAll()
                .stream()
                .map(departmentMapper::departmentModelToDepartmentDTO)
                .collect(Collectors.toList());
    }

    public UUID addDepartment(DepartmentDTO departmentDTO) {
        DepartmentModel newDepartment = new DepartmentModel();
        departmentMapper.departmentDTOToDepartmentModel(departmentDTO, newDepartment);
        departmentRepository.save(newDepartment);
        return newDepartment.getId();
    }

    public UUID deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
        return id;
    }


    public DepartmentDTO getDepartmentDTOById(UUID id) {
        DepartmentModel departmentModel = departmentRepository.findById(id).orElse(null);
        return departmentMapper.departmentModelToDepartmentDTO(departmentModel);
    }

    public UUID editDepartment(DepartmentDTO departmentDTO, UUID id) {
        DepartmentModel departmentModel = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));
        departmentMapper.departmentDTOToDepartmentModel(departmentDTO, departmentModel);
        departmentRepository.save(departmentModel);
        return departmentModel.getId();

    }
}
