package com.example.carrental.controller;

import com.example.carrental.DTO.CarDTO;
import com.example.carrental.mapper.CarMapper;
import com.example.carrental.model.CarModel;
import com.example.carrental.model.CarStatus;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarModel> getCars() {

        return carService.getAllCars();
    }

    @GetMapping("/available")
    public List<CarModel> getAllAvailableCars(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return carService.displayAllAvailableCars(startDate, endDate);
    }


    @PostMapping
    public void addCar(@RequestBody CarDTO carDTO) {
        carService.addCar(carDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }


    @PutMapping("/{id}")
    public void editCar(@PathVariable("id") Long id, @RequestBody CarDTO carDTO){
    CarModel carModel = carService.getCarModelById(id);
    carService.editCar(carDTO, carModel);
    }


    @GetMapping("/status/{id}")
    public CarStatus getCarStatusOnAGivenDay(@PathVariable("id") Long id, LocalDate localDate){
        CarModel carModel = carService.getCarModelById(id);
        return carService.getCarStatusOnGivenDay(localDate, carModel);
    }

}
