package com.example.carrental.controller;

import com.example.carrental.controller.DTO.CarDTO;
import com.example.carrental.controller.validation.CarDTOValidator;
import com.example.carrental.repository.model.CarModel;
import com.example.carrental.repository.model.CarStatus;
import com.example.carrental.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarDTOValidator carDTOValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(carDTOValidator);
    }

    @GetMapping("/getall")
    public List<CarDTO> getCars() {
        return carService.getAllCars();
    }

    @GetMapping("/available")
    public List<CarDTO> getAllAvailableCars(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return carService.displayAllAvailableCars(startDate, endDate);
    }


    @PostMapping("/add")
    public UUID addCar(@Valid @RequestBody CarDTO carDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new IllegalArgumentException("Invalid data input");
        }
        return carService.addCar(carDTO);
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteCarById(@PathVariable("id") UUID id) {
         return carService.deleteCar(id);
    }


    @PutMapping("/edit/{id}")
    public UUID editCar(@PathVariable("id") UUID id, @Valid @RequestBody CarDTO carDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new IllegalArgumentException("Invalid data input");
        }
    return carService.editCar(id, carDTO);
    }


    @GetMapping("/status/{id}")
    public CarStatus getCarStatusOnAGivenDay(@PathVariable("id") UUID id, LocalDate localDate){

        return carService.getCarStatusOnGivenDay(localDate, id);
    }

}
