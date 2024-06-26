package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.CarRentalDTO;
import com.example.carrental.repository.CarRentalRepository;
import com.example.carrental.repository.model.CarRentalModel;
import org.springframework.stereotype.Component;

@Component
public class CarRentalMapper {
    private final CarRentalRepository carRentalRepository;

    public CarRentalMapper(CarRentalRepository carRentalRepository) {
        this.carRentalRepository = carRentalRepository;
    }

    public CarRentalModel carRentalDTOToCarRentalModel (CarRentalDTO carRentalDTO, CarRentalModel carRentalModel) {

    if (carRentalDTO.getName() != null) {
        carRentalModel.setName(carRentalDTO.getName());
    }

    if (carRentalDTO.getAddress() != null) {
        carRentalModel.setAddress(carRentalDTO.getAddress());
    }


    if (carRentalDTO.getDomain() != null) {
        carRentalModel.setDomain(carRentalDTO.getDomain());
    }

    if (carRentalDTO.getLogotype() != null) {
        carRentalModel.setLogotype(carRentalDTO.getLogotype());
    }

    return carRentalModel;

    }

    public CarRentalDTO carRentalModelToCarRentalDTO (CarRentalModel carRentalModel) {
        CarRentalDTO carRentalDTO = new CarRentalDTO();
        carRentalDTO.setAddress(carRentalModel.getAddress());
        carRentalDTO.setLogotype(carRentalModel.getLogotype());
        carRentalDTO.setName(carRentalModel.getName());
        carRentalDTO.setDomain(carRentalModel.getDomain());
        carRentalDTO.setCustomerModelSet(carRentalModel.getCustomerModelSet());
        carRentalDTO.setDepartmentModelSet(carRentalModel.getDepartmentModelSet());
        carRentalDTO.setEmployeeModelList(carRentalModel.getEmployeeModelList());
        carRentalDTO.setCarModelList(carRentalModel.getCarModelList());
        return carRentalDTO;
    }

}
