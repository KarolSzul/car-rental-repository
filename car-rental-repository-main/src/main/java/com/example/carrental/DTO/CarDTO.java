package com.example.carrental.DTO;

import com.example.carrental.model.CarRentalModel;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarDTO {

    private String brand;
    private String model;
    private String bodyType;
    private String color;
    private Integer yearOfProduction;
    private Integer mileage;
    private Double pricePerDay;
    private CarRentalModel carRental;


}
