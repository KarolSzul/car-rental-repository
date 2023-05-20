package com.example.carrental.service;

import com.example.carrental.DTO.CarStatusHistoryDTO;
import com.example.carrental.mapper.CarStatusHistoryMapper;
import com.example.carrental.model.CarModel;
import com.example.carrental.model.CarStatusHistoryModel;
import com.example.carrental.repository.CarStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarSatusHistoryService {

    private final CarStatusHistoryRepository carStatusHistoryRepository;

    public void addCarStatusHistoryRecord (CarStatusHistoryDTO carStatusHistoryDTO) {
        CarStatusHistoryModel carStatusHistoryModel = new CarStatusHistoryModel();
        CarStatusHistoryMapper carStatusHistoryMapper = new CarStatusHistoryMapper();
        carStatusHistoryMapper.carStatusHistoryDTOToCarStatusHistoryModel(carStatusHistoryModel, carStatusHistoryDTO);
        carStatusHistoryRepository.save(carStatusHistoryModel);
    }

    public void editCarStatusHistoryRecord (CarStatusHistoryDTO carStatusHistoryDTO, CarStatusHistoryModel carStatusHistoryModel) {
        CarStatusHistoryMapper carStatusHistoryMapper = new CarStatusHistoryMapper();
        carStatusHistoryMapper.carStatusHistoryDTOToCarStatusHistoryModel(carStatusHistoryModel, carStatusHistoryDTO);
        carStatusHistoryRepository.save(carStatusHistoryModel);
    }

    public void deleteCarStatusHistoryRecord (Long id) {
        carStatusHistoryRepository.deleteById(id);
    }

    public List<CarStatusHistoryModel> getCarStatusHistory (Long id) {
        return carStatusHistoryRepository.findAll().stream().filter(car -> car.getCarModel().getId().equals(id) ).collect(Collectors.toList());
    }

    public CarStatusHistoryModel getCarStatusHistoryRecord (Long id) {
        return carStatusHistoryRepository.findById(id).orElse(null);
    }


}
