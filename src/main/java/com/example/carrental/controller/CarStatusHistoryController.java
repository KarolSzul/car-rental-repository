package com.example.carrental.controller;

import com.example.carrental.DTO.CarStatusHistoryDTO;
import com.example.carrental.model.CarStatusHistoryModel;
import com.example.carrental.service.CarStatusHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statushistory")
@RequiredArgsConstructor
public class CarStatusHistoryController {

    private final CarStatusHistoryService carStatusHistoryService;

    @GetMapping("/{id}")
    public List<CarStatusHistoryModel> getCarStatusHistoryForASingleCar (@PathVariable Long id) {
        return carStatusHistoryService.getCarStatusHistory(id);
    }

    @PostMapping
    public void addCarStatusHistory (@RequestBody CarStatusHistoryDTO carStatusHistoryDTO) {
        carStatusHistoryService.addCarStatusHistoryRecord(carStatusHistoryDTO);
    }

    @PutMapping("/{id}")
    public void editCarStatusHistory (@PathVariable Long id, CarStatusHistoryDTO carStatusHistoryDTO) {
        CarStatusHistoryModel carStatusHistoryModel = carStatusHistoryService.getCarStatusHistoryRecord(id);
        carStatusHistoryService.editCarStatusHistoryRecord(carStatusHistoryDTO, carStatusHistoryModel);
    }

    @DeleteMapping("/{id}")
    public void deleteCarStatusHistory (@PathVariable Long id) {
        carStatusHistoryService.deleteCarStatusHistoryRecord(id);
    }


}
