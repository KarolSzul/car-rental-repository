package com.example.carrental.controller.validation;

import com.example.carrental.controller.DTO.CustomerDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class CustomerDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        CustomerDTO customerDTO = (CustomerDTO) target;
        String nameRegexPattern = "/^[a-z ,.'-]+$/i";
        String emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if(!Pattern.compile(emailRegexPattern).matcher(customerDTO.getEmail()).matches()) {
            errors.rejectValue("email", "E-mail has a wrong format");
        }
        else if(!Pattern.compile(nameRegexPattern).matcher(customerDTO.getFirstName()).matches()) {
            errors.rejectValue("firstName", "Insert a correct first name");
        }
        else if(!Pattern.compile(nameRegexPattern).matcher(customerDTO.getLastName()).matches()) {
            errors.rejectValue("lastName", "Insert a correct last name");
        }


    }
}
