package com.example.carrental.controller.DTO;


import com.example.carrental.repository.model.CarRentalModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private CarRentalModel carRentalModel;




}
