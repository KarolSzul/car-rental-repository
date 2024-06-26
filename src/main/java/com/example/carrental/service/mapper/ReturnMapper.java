package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.ReturnDTO;
import com.example.carrental.repository.model.ReturnModel;
import org.springframework.stereotype.Component;

@Component
public class ReturnMapper {

    public ReturnModel returnDTOToReturnModel(ReturnDTO returnDTO, ReturnModel returnModel){

        if (returnDTO.getEmployeeModel() != null){
            returnModel.setEmployeeModel(returnDTO.getEmployeeModel());
        }
        if (returnDTO.getReturnDate() != null){
            returnModel.setReturnDate(returnDTO.getReturnDate());
        }
        if (returnDTO.getReservationModel() != null){
            returnModel.setReservationModel(returnDTO.getReservationModel());
        }
        if (returnDTO.getExtraCharge() != null){
            returnModel.setExtraCharge(returnDTO.getExtraCharge());
        }
        if (returnDTO.getComments() != null) {
            returnModel.setComments(returnDTO.getComments());
        }
        return returnModel;
    }

    public ReturnDTO returnModelToReturnDTO (ReturnModel returnModel) {
        ReturnDTO returnDTO = new ReturnDTO();
        returnDTO.setEmployeeModel(returnModel.getEmployeeModel());
        returnDTO.setReturnDate(returnModel.getReturnDate());
        returnDTO.setReservationModel(returnModel.getReservationModel());
        returnDTO.setExtraCharge(returnModel.getExtraCharge());
        returnDTO.setComments(returnModel.getComments());
        return returnDTO;
    }

}
