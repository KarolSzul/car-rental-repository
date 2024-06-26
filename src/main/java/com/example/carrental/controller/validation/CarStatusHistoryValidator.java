package com.example.carrental.controller.validation;


import com.example.carrental.controller.DTO.CarDTO;
import com.example.carrental.controller.DTO.CarStatusHistoryDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CarStatusHistoryValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
       return CarStatusHistoryDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarStatusHistoryDTO carStatusHistoryDTO = (CarStatusHistoryDTO) target;
        if (carStatusHistoryDTO.getStartDate().isAfter(carStatusHistoryDTO.getEndDate())){
            errors.rejectValue("endDate", "EndDate cannot be before Startdate.");
        }

    }
}
