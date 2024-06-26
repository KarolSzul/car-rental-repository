package com.example.carrental.controller.validation;

import com.example.carrental.controller.DTO.ReservationDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReservationDTOValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return ReservationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReservationDTO reservationDTO = (ReservationDTO) target;
        if (reservationDTO.getReservationStartDate().isBefore(reservationDTO.getReservationBookingDate())){
            errors.rejectValue("reservationStartDate", "The reservation start date cannot be in the past");
        }
        else if (reservationDTO.getReservationEndDate().isBefore(reservationDTO.getReservationStartDate())) {
            errors.rejectValue("reservationEndDate", "The reservation cannot end before it starts.");
        }

    }
}
