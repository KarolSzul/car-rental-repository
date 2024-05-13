package com.example.carrental.service;

import com.example.carrental.DTO.CarDTO;
import com.example.carrental.mapper.CarMapper;
import com.example.carrental.model.*;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;


    public void addCar(CarDTO carDTO) {
        CarModel newCar = new CarModel();
        carMapper.carDTOToCarModel(carDTO, newCar);
        carRepository.save(newCar);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public void editCar(CarDTO carDTO, CarModel editedCarModel) {
        carMapper.carDTOToCarModel(carDTO, editedCarModel);
        carRepository.save(editedCarModel);
    }

    public CarStatus getCarStatusOnGivenDay(LocalDate date, CarModel carModel) {
        List<CarStatusHistoryModel> statusHistoryModelsOfAGivenCar = carModel.getCarStatusHistoryModels();
        for (CarStatusHistoryModel statusHistoryModelsOfAGivenCarRecord : statusHistoryModelsOfAGivenCar) {
            if (date.isAfter(statusHistoryModelsOfAGivenCarRecord.getStartDate()) && date.isAfter(statusHistoryModelsOfAGivenCarRecord.getEndDate())) {
                return statusHistoryModelsOfAGivenCarRecord.getCarStatus();
            }

        }
        return CarStatus.AVAILABLE;
    }

    public CarModel getCarAvailabilityInAGivenPeriod (CarModel carModel, LocalDate startDate, LocalDate endDate) {
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
            if (getCarStatusOnGivenDay(date, carModel) != CarStatus.AVAILABLE) {
                return null;
            }
        }
        return carModel;
    }

    public List<CarModel> getAllCars() {
        return carRepository.findAll();
    }

    public CarModel getCarModelById(Long id) {
        return carRepository.findById(id).orElse(null);
    }



    public List<CarModel> displayAllAvailableCars(LocalDate startDate, LocalDate endDate) {
        List<CarModel> allAvilableCarsList = new ArrayList<>();
        List<CarModel> allCars = getAllCars();
        for(CarModel car : allCars) {
            if(getCarAvailabilityInAGivenPeriod(car,startDate,endDate) != null) {
                allAvilableCarsList.add(car);
            }
        }
        return allAvilableCarsList;
    }



}
