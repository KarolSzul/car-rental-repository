package com.example.carrental.controller;

import com.example.carrental.DTO.CarDTO;
import com.example.carrental.model.CarModel;
import com.example.carrental.model.CarStatus;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarModel> getCars() {
//    return new CarModel(1L, "sdsad", "sadasd", "asdasd", "sadas",123, 21312,123, List.of(), null); // sprawdzenie
        return carService.getAllCars();
    }


    @PostMapping
    public void addCar(@RequestBody CarDTO carDTO) {
        carService.addCar(carDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }


    @PostMapping("/edit/{id}")
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
