package com.example.carrental.service;

import com.example.carrental.controller.DTO.EmployeeDTO;
import com.example.carrental.service.mapper.EmployeeMapper;
import com.example.carrental.repository.model.EmployeeModel;
import com.example.carrental.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(employeeMapper::employeeModelToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public UUID addEmployee(EmployeeDTO employeeDTO) {
        EmployeeModel newEmployee = new EmployeeModel();
        employeeMapper.employeeDTOTOEmployeeModel(employeeDTO, newEmployee);
        employeeRepository.save(newEmployee);
        return newEmployee.getId();
    }

    public UUID deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
        return id;
    }

    public EmployeeDTO getEmployeeDTOById(UUID id) {
        EmployeeModel employeeModel = employeeRepository.findById(id).orElse(null);
        return employeeMapper.employeeModelToEmployeeDTO(employeeModel);
    }


    public UUID editEmployee(EmployeeDTO employeeDTO, UUID id) {
        EmployeeModel employeeModel = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));
        employeeMapper.employeeDTOTOEmployeeModel(employeeDTO,employeeModel);
        employeeRepository.save(employeeModel);
        return employeeModel.getId();
    }
}
