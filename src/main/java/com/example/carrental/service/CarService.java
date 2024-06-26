package com.example.carrental.service;

import com.example.carrental.controller.DTO.CarDTO;
import com.example.carrental.repository.model.CarModel;
import com.example.carrental.repository.model.CarStatus;
import com.example.carrental.repository.model.CarStatusHistoryModel;
import com.example.carrental.service.mapper.CarMapper;
import com.example.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;


    public UUID addCar(CarDTO carDTO) {
        CarModel newCar = new CarModel();
        carMapper.carDTOToCarModel(carDTO, newCar);
        carRepository.save(newCar);
        return newCar.getId();
    }

    public UUID deleteCar(UUID id) {
        carRepository.deleteById(id);
        return id;
    }

    public UUID editCar(UUID id, CarDTO carDTO) {
        CarModel carModel = carRepository.findById(id).orElse(null);
        carMapper.carDTOToCarModel(carDTO, carModel);
        carRepository.save(carModel);
        return id;
    }

    public CarStatus getCarStatusOnGivenDay(LocalDate date, UUID id) {
        CarModel carModel = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong id"));
            List<CarStatusHistoryModel> statusHistoryModelsOfAGivenCar = carModel.getCarStatusHistoryModels();
            for (CarStatusHistoryModel statusHistoryModelsOfAGivenCarRecord : statusHistoryModelsOfAGivenCar) {
                if (date.isAfter(statusHistoryModelsOfAGivenCarRecord.getStartDate()) && date.isAfter(statusHistoryModelsOfAGivenCarRecord.getEndDate())) {
                    return statusHistoryModelsOfAGivenCarRecord.getCarStatus();
                }

            }

            return CarStatus.AVAILABLE;
    }

    public CarStatus getCarAvailabilityInAGivenPeriod (UUID id, LocalDate startDate, LocalDate endDate) {
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
            if (getCarStatusOnGivenDay(date, id) != CarStatus.AVAILABLE) {
                return CarStatus.RESERVED;
            }
        }
        return CarStatus.AVAILABLE;
    }

    public List<CarDTO> getAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(carMapper::carModelToCarDTO)
                .collect(Collectors.toList());
    }

    public CarDTO getCarDTOById(UUID id) {
        CarModel carModel = carRepository.findById(id).orElse(null);
        return carMapper.carModelToCarDTO(carModel);
    }



    public List<CarDTO> displayAllAvailableCars(LocalDate startDate, LocalDate endDate) {
        return carRepository
                .findAll()
                .stream()
                .filter(c -> getCarAvailabilityInAGivenPeriod(c.getId(),startDate,endDate) != null)
                .map(carMapper::carModelToCarDTO)
                .collect(Collectors.toList());

    } // czy da się to usprawnić



}
