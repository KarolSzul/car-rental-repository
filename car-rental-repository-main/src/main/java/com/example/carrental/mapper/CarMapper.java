package com.example.carrental.mapper;

import com.example.carrental.DTO.CarDTO;
import com.example.carrental.model.CarModel;
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
        if (carDTO.getCarRental() != null){
            carModel.setCarRental(carDTO.getCarRental());
        }

        return carModel;
    }

}
