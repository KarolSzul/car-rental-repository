package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.ReservationDTO;
import com.example.carrental.repository.model.ReservationModel;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public ReservationModel reservationDTOToReservationModel(ReservationDTO reservationDTO, ReservationModel reservationModel) {

        if (reservationDTO.getReservationStartDate() != null) {
            reservationModel.setReservationStartDate((reservationDTO.getReservationStartDate()));
        }
        if (reservationDTO.getReservationEndDate() != null) {
            reservationModel.setReservationEndDate(reservationDTO.getReservationEndDate());
        }
        if (reservationDTO.getCustomerModel() != null) {
            reservationModel.setCustomerModel(reservationDTO.getCustomerModel());
        }
        if (reservationDTO.getCarModel() != null) {
            reservationModel.setCarModel(reservationDTO.getCarModel());
        }

        if (reservationDTO.getStartDepartmentModel() != null) {
            reservationModel.setStartDepartmentModel(reservationDTO.getStartDepartmentModel());
        }

        if (reservationDTO.getDestinationDepartmentModel() != null) {
            reservationModel.setDestinationDepartmentModel(reservationDTO.getDestinationDepartmentModel());
        }
        if (reservationDTO.getPrice() != null) {
            reservationModel.setPrice(reservationDTO.getPrice());
        }

        return reservationModel;
    }

    public ReservationDTO reservationModelToReservationDTO (ReservationModel reservationModel) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationEndDate(reservationModel.getReservationEndDate());
        reservationDTO.setReservationStartDate(reservationModel.getReservationStartDate());
        reservationDTO.setCarModel(reservationModel.getCarModel());
        reservationDTO.setPrice(reservationModel.getPrice());
        reservationDTO.setStartDepartmentModel(reservationModel.getStartDepartmentModel());
        reservationDTO.setDestinationDepartmentModel(reservationModel.getDestinationDepartmentModel());
        reservationDTO.setCustomerModel(reservationModel.getCustomerModel());
        reservationDTO.setReservationBookingDate(reservationModel.getReservationBookingDate());
        return reservationDTO;
    }



}









