package com.example.carrental.service;

import com.example.carrental.controller.DTO.CarRentalDTO;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.service.mapper.CarRentalMapper;
import com.example.carrental.repository.model.CarRentalModel;
import com.example.carrental.repository.CarRentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;
    private final CarRentalMapper carRentalMapper;
    

    public UUID addCarRental(CarRentalDTO carRentalDTO) {
        CarRentalModel newCarRentalModel = new CarRentalModel();
        carRentalMapper.carRentalDTOToCarRentalModel(carRentalDTO, newCarRentalModel);
        carRentalRepository.save(newCarRentalModel);
        UUID id = newCarRentalModel.getId();
        return id;
    }

    public UUID deleteCarRental(UUID id) {
        carRentalRepository.deleteById(id);
        return id;
    }

    public UUID editCarRental(CarRentalDTO carRentalDTO, UUID id) {
        CarRentalModel carRentalModel = carRentalRepository.findById(id).orElse(null);
        carRentalMapper.carRentalDTOToCarRentalModel(carRentalDTO, carRentalModel);
        return id;
    }

    public CarRentalDTO getCarRentalDTOById(UUID id) {
        CarRentalModel carRentalModel = carRentalRepository.findById(id).orElse(null);
        return carRentalMapper.carRentalModelToCarRentalDTO(carRentalModel);
    }

    public List<CarRentalDTO> getAllCarRentalDTOs() {
        return carRentalRepository
                .findAll()
                .stream()
                .map(carRentalMapper::carRentalModelToCarRentalDTO)
                .collect(Collectors.toList());
    }
}
