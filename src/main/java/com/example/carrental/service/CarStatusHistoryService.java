package com.example.carrental.service;

import com.example.carrental.controller.DTO.CarStatusHistoryDTO;
import com.example.carrental.service.mapper.CarStatusHistoryMapper;
import com.example.carrental.repository.model.CarStatusHistoryModel;
import com.example.carrental.repository.CarStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarStatusHistoryService {

    private final CarStatusHistoryRepository carStatusHistoryRepository;

    private final CarStatusHistoryMapper carStatusHistoryMapper;


    public UUID addCarStatusHistoryRecord (CarStatusHistoryDTO carStatusHistoryDTO) {
        CarStatusHistoryModel carStatusHistoryModel = new CarStatusHistoryModel();
        CarStatusHistoryMapper carStatusHistoryMapper = new CarStatusHistoryMapper();
        carStatusHistoryMapper.carStatusHistoryDTOToCarStatusHistoryModel(carStatusHistoryModel, carStatusHistoryDTO);
        carStatusHistoryRepository.save(carStatusHistoryModel);
        return carStatusHistoryModel.getId();
    }

    public UUID editCarStatusHistoryRecord (CarStatusHistoryDTO carStatusHistoryDTO, UUID id) {
        CarStatusHistoryModel carStatusHistoryModel = carStatusHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));;
        CarStatusHistoryMapper carStatusHistoryMapper = new CarStatusHistoryMapper();
        carStatusHistoryMapper.carStatusHistoryDTOToCarStatusHistoryModel(carStatusHistoryModel, carStatusHistoryDTO);
        carStatusHistoryRepository.save(carStatusHistoryModel);
        return carStatusHistoryModel.getId();
    }

    public UUID deleteCarStatusHistoryRecord (UUID id) {
        carStatusHistoryRepository.deleteById(id);
        return id;
    }

    public List<CarStatusHistoryDTO> getCarStatusHistory (UUID id) {
        return carStatusHistoryRepository
                .findAll()
                .stream()
                .filter(car -> car.getCarModel().getId().equals(id))
                .map(carStatusHistoryMapper::carStatusHistoryModelToCarStatusHistoryDTO)
                .collect(Collectors.toList());
    }

    public CarStatusHistoryDTO getCarStatusHistoryRecord (UUID id) {
        CarStatusHistoryModel carStatusHistoryModel = carStatusHistoryRepository.findById(id).orElse(null);
        return carStatusHistoryMapper.carStatusHistoryModelToCarStatusHistoryDTO(carStatusHistoryModel);
    }


}
