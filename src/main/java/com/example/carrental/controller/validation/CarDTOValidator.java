package com.example.carrental.controller.validation;


import com.example.carrental.controller.DTO.CarDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CarDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CarDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearOfProduction", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mileage", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pricePerDay", "field.required");


        CarDTO carDTO = (CarDTO) target;
        if (carDTO.getPricePerDay()<50||carDTO.getPricePerDay()>500) {
            errors.rejectValue("pricePerDay", "Price invalid. Check it and try again.");
        } else if (carDTO.getMileage()<0) {
            errors.rejectValue("mileage", "Mileage cannot be a negative value.");

        }

    }
}
