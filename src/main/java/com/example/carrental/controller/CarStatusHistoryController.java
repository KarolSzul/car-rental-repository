package com.example.carrental.controller;

import com.example.carrental.controller.DTO.CarStatusHistoryDTO;
import com.example.carrental.controller.validation.CarStatusHistoryValidator;
import com.example.carrental.repository.model.CarStatusHistoryModel;
import com.example.carrental.service.CarStatusHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/statushistory")
@RequiredArgsConstructor
public class CarStatusHistoryController {

    private final CarStatusHistoryService carStatusHistoryService;
    private final CarStatusHistoryValidator carStatusHistoryValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(carStatusHistoryValidator);
    }

    @GetMapping("/{id}")
    public List<CarStatusHistoryDTO> getCarStatusHistoryForASingleCar (@PathVariable UUID id) {
        return carStatusHistoryService.getCarStatusHistory(id);
    }

    @PostMapping("/add")
    public UUID addCarStatusHistory (@RequestBody @Valid CarStatusHistoryDTO carStatusHistoryDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid data input");
        }
        return carStatusHistoryService.addCarStatusHistoryRecord(carStatusHistoryDTO);
    }

    @PutMapping("/edit/{id}")
    public UUID editCarStatusHistory (@PathVariable UUID id, @RequestBody @Valid CarStatusHistoryDTO carStatusHistoryDTO,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new IllegalArgumentException("Invalid data input");
        }
        return carStatusHistoryService.editCarStatusHistoryRecord(carStatusHistoryDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteCarStatusHistory (@PathVariable UUID id) {
        return carStatusHistoryService.deleteCarStatusHistoryRecord(id);
    }


}
