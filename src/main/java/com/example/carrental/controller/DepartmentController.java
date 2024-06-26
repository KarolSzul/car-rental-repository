package com.example.carrental.controller;


import com.example.carrental.controller.DTO.DepartmentDTO;
import com.example.carrental.repository.model.DepartmentModel;
import com.example.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping("/getall")
    public List<DepartmentDTO> getDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/get/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable UUID id){
        return departmentService.getDepartmentDTOById(id);
    }

    @PostMapping("/add")
    public UUID addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.addDepartment(departmentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteDepartmentById(@PathVariable("id") UUID id) {
        return departmentService.deleteDepartment(id);
    }

    @PutMapping("/edit/{id}")
    public UUID editDepartment(@PathVariable("id") UUID id, @RequestBody DepartmentDTO departmentDTO){
        return departmentService.editDepartment(departmentDTO, id);
    }


}
