package com.example.carrental.controller.DTO;

import com.example.carrental.repository.model.CarRentalModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO implements Serializable {

    private String brand;
    private String model;
    private String bodyType;
    private String color;
    private Integer yearOfProduction;
    private Integer mileage;
    private Double pricePerDay;
    private Double pricePerKm;
    private CarRentalModel carRentalModel;


}
