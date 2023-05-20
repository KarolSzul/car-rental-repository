package com.example.carrental.mapper;

import com.example.carrental.DTO.CarStatusHistoryDTO;
import com.example.carrental.model.CarStatusHistoryModel;

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
}
