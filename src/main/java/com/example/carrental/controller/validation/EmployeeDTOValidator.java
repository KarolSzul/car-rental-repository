package com.example.carrental.controller.validation;

import com.example.carrental.controller.DTO.EmployeeDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class EmployeeDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        String nameRegexPattern = "/^[a-z ,.'-]+$/i";
        EmployeeDTO employeeDTO = (EmployeeDTO) target;

        if (!Pattern.compile(nameRegexPattern).matcher(employeeDTO.getFirstName()).matches()) {
            errors.rejectValue("firstName", "Insert a correct first name");
        }
        else if (!Pattern.compile(nameRegexPattern).matcher(employeeDTO.getLastName()).matches()) {
            errors.rejectValue("firstName", "Insert a correct first name");
        }


    }
}
