package com.example.carrental.controller;


import com.example.carrental.DTO.DepartmentDTO;
import com.example.carrental.model.DepartmentModel;
import com.example.carrental.service.CarService;
import com.example.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping
    public List<DepartmentModel> getDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentModel getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentModelById(id);
    }

    @PostMapping
    public void addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.addDepartment(departmentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
    }

    @PutMapping("/{id}")
    public void editDepartment(@PathVariable("id") Long id, @RequestBody DepartmentDTO departmentDTO){
        DepartmentModel departmentModel = departmentService.getDepartmentModelById(id);
        departmentService.editDepartment(departmentDTO, departmentModel);
    }


}
