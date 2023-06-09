package com.example.carrental.controller;


import com.example.carrental.DTO.DepartmentDTO;
import com.example.carrental.model.DepartmentModel;
import com.example.carrental.service.CarService;
import com.example.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping
    public List<DepartmentModel> getDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public void addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.addDepartment(departmentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
    }

    @PostMapping("/edit/{id}")
    public void editDepartment(@PathVariable("id") Long id, @RequestBody DepartmentDTO departmentDTO){
        DepartmentModel departmentModel = departmentService.getDepartmentModelById(id);
        departmentService.editDepartment(departmentDTO, departmentModel);
    }


}
