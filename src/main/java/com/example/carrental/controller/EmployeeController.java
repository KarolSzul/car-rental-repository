package com.example.carrental.controller;

import com.example.carrental.controller.DTO.EmployeeDTO;
import com.example.carrental.controller.validation.EmployeeDTOValidator;
import com.example.carrental.repository.EmployeeRepository;
import com.example.carrental.repository.model.EmployeeModel;
import com.example.carrental.service.EmployeeService;
import com.example.carrental.service.mapper.EmployeeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeDTOValidator employeeDTOValidator;

    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(employeeDTOValidator);
    }


    @GetMapping("/getall")
    public List<EmployeeDTO> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeeDTO getEmployeeById(UUID id) {
        return employeeService.getEmployeeDTOById(id);
    }

    @PostMapping("/add")
    public UUID addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new IllegalArgumentException("Invalid data input");
        }
        return employeeService.addEmployee(employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteEmployeeById(@PathVariable("id") UUID id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/edit/{id}")
    public UUID editEmployee(@PathVariable("id") UUID id, @Valid @RequestBody EmployeeDTO employeeDTO,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid data input");
        }
        return employeeService.editEmployee(employeeDTO, id);
    }



}
