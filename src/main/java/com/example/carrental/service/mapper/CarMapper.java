package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.CarDTO;
import com.example.carrental.repository.model.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarModel carDTOToCarModel(CarDTO carDTO, CarModel carModel){
        if (carDTO.getBrand() != null){
            carModel.setBrand((carDTO.getBrand()));
        }
        if (carDTO.getModel() != null){
            carModel.setModel(carDTO.getModel());
        }
        if (carDTO.getBodyType() != null){
            carModel.setBodyType(carDTO.getBodyType());
        }
        if (carDTO.getColor() != null){
            carModel.setColor(carDTO.getColor());
        }
        if (carDTO.getYearOfProduction() != null){
            carModel.setYearOfProduction(carDTO.getYearOfProduction());
        }
        if (carDTO.getMileage() != null){
            carModel.setMileage(carDTO.getMileage());
        }
        if (carDTO.getPricePerDay() != null){
            carModel.setPricePerDay(carDTO.getPricePerDay());
        }
        if (carDTO.getCarRentalModel() != null){
            carModel.setCarRentalModel(carDTO.getCarRentalModel());
        }

        return carModel;
    }

    public CarDTO carModelToCarDTO (CarModel carModel) {
        CarDTO carDTO = new CarDTO();
        carDTO.setModel(carModel.getModel());
        carDTO.setCarRentalModel(carModel.getCarRentalModel());
        carDTO.setMileage(carModel.getMileage());
        carDTO.setBodyType(carModel.getBodyType());
        carDTO.setPricePerDay(carModel.getPricePerDay());
        carDTO.setColor(carModel.getColor());
        carDTO.setYearOfProduction(carModel.getYearOfProduction());
        carDTO.setBrand(carModel.getBrand());
        return carDTO;
    }

}
