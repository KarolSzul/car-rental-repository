package com.example.carrental.controller;

import com.example.carrental.DTO.CarStatusHistoryDTO;
import com.example.carrental.model.CarStatusHistoryModel;
import com.example.carrental.repository.CarStatusHistoryRepository;
import com.example.carrental.service.CarSatusHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statushistory")
@RequiredArgsConstructor
public class CarStatusHistoryController {

    private final CarSatusHistoryService carSatusHistoryService;

    @GetMapping("/{id}")
    public List<CarStatusHistoryModel> getCarStatusHistoryForASingleCar (@PathVariable Long id) {
        return carSatusHistoryService.getCarStatusHistory(id);
    }

    @PostMapping
    public void addCarStatusHistory (@RequestBody CarStatusHistoryDTO carStatusHistoryDTO) {
        carSatusHistoryService.addCarStatusHistoryRecord(carStatusHistoryDTO);
    }

    @PostMapping("/edit/{id}")
    public void editCarStatusHistory (@PathVariable Long id, CarStatusHistoryDTO carStatusHistoryDTO) {
        CarStatusHistoryModel carStatusHistoryModel = carSatusHistoryService.getCarStatusHistoryRecord(id);
        carSatusHistoryService.editCarStatusHistoryRecord(carStatusHistoryDTO, carStatusHistoryModel);
    }

    @DeleteMapping("/{id}")
    public void deleteCarStatusHistory (@PathVariable Long id) {
        carSatusHistoryService.deleteCarStatusHistoryRecord(id);
    }


}
