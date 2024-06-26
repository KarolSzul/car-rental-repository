package com.example.carrental.controller.validation;

import com.example.carrental.controller.DTO.ReturnDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReturnDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ReturnDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReturnDTO returnDTO = (ReturnDTO) target;
        if (returnDTO.getExtraCharge() < 0) {
            errors.rejectValue("extraCharge", "The charge cannot be negative.");
        }

    }
}
