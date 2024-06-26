package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.CarDTO;
import com.example.carrental.controller.DTO.CarStatusHistoryDTO;
import com.example.carrental.repository.model.CarStatusHistoryModel;
import org.springframework.stereotype.Component;

@Component
public class CarStatusHistoryMapper {


    public CarStatusHistoryModel carStatusHistoryDTOToCarStatusHistoryModel (CarStatusHistoryModel carStatusHistoryModel, CarStatusHistoryDTO carStatusHistoryDTO) {
        if (carStatusHistoryDTO.getStartDate() != null) {
            carStatusHistoryModel.setStartDate(carStatusHistoryDTO.getStartDate());
        }

        if (carStatusHistoryDTO.getEndDate() != null) {
            carStatusHistoryModel.setEndDate(carStatusHistoryDTO.getEndDate());
        }
        if (carStatusHistoryDTO.getCarStatus() != null) {
            carStatusHistoryModel.setCarStatus(carStatusHistoryDTO.getCarStatus());
        }
        if (carStatusHistoryDTO.getCarModel() != null) {
            carStatusHistoryModel.setCarModel(carStatusHistoryDTO.getCarModel());
        }

        return carStatusHistoryModel;
    }

    public CarStatusHistoryDTO carStatusHistoryModelToCarStatusHistoryDTO (CarStatusHistoryModel carStatusHistoryModel){
        CarStatusHistoryDTO carStatusHistoryDTO = new CarStatusHistoryDTO();
        carStatusHistoryDTO.setCarModel(carStatusHistoryModel.getCarModel());
        carStatusHistoryDTO.setCarStatus(carStatusHistoryModel.getCarStatus());
        carStatusHistoryDTO.setStartDate(carStatusHistoryModel.getStartDate());
        carStatusHistoryDTO.setEndDate(carStatusHistoryModel.getEndDate());
        return carStatusHistoryDTO;
    }

}
