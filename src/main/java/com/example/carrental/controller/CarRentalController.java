package com.example.carrental.controller;

import com.example.carrental.controller.DTO.CarRentalDTO;
import com.example.carrental.repository.model.CarRentalModel;
import com.example.carrental.service.CarRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carrental")
@RequiredArgsConstructor
public class CarRentalController {

    private final CarRentalService carRentalService;

    @GetMapping("/getall")
    public List<CarRentalDTO> getAllCarRentalModels() {
        return carRentalService.getAllCarRentalDTOs();
    }

    @GetMapping("/get/{id}")
    public CarRentalDTO getCarRentalModelById(UUID id){
        return carRentalService.getCarRentalDTOById(id);
    }

    @PostMapping("/add")
    public UUID addCarRental(@RequestBody CarRentalDTO carRentalDTO) {
        return carRentalService.addCarRental(carRentalDTO);
    }

    @PostMapping("/edit/{id}")
    public UUID editCarRental(@RequestBody CarRentalDTO carRentalDTO, @PathVariable UUID id){
        return carRentalService.editCarRental(carRentalDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteCarRental(@PathVariable UUID id){
        return carRentalService.deleteCarRental(id);
    }



}
