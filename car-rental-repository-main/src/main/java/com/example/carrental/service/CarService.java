package com.example.carrental.service;

import com.example.carrental.DTO.CarDTO;
import com.example.carrental.mapper.CarMapper;
import com.example.carrental.model.CarModel;
import com.example.carrental.model.CarStatus;
import com.example.carrental.model.CarStatusHistoryModel;
import com.example.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

//    public void addCar(CarModel carModel) {
//        carRepository.save(carModel);
//    }

    public void addCar(CarDTO carDTO) {
        CarModel newCar = new CarModel();
        carMapper.carDTOToCarModel(carDTO, newCar);
        carRepository.save(newCar);
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

    public void editCar (CarDTO carDTO, CarModel editedCarModel) {
        carMapper.carDTOToCarModel(carDTO, editedCarModel);
        carRepository.save(editedCarModel);
    }



    public CarStatus getCarStatusOnGivenDay(LocalDate date, CarModel carModel) {
        List<CarStatusHistoryModel> statusHistoryModelsOfAGivenCar = carModel.getCarStatusHistoryModels();
        for(CarStatusHistoryModel statusHistoryModelsOfAGivenCarRecord: statusHistoryModelsOfAGivenCar) {
            if(date.isAfter(statusHistoryModelsOfAGivenCarRecord.getStartDate())  &&  date.isAfter(statusHistoryModelsOfAGivenCarRecord.getEndDate())){
            return statusHistoryModelsOfAGivenCarRecord.getCarStatus();
        }

        }
        return CarStatus.AVAILABLE;
    }

    public List<CarModel> getAllCars() {
        return carRepository.findAll();
    }

    public CarModel getCarModelById(Long id){
        return carRepository.findById(id).orElse(null);
    }

}
