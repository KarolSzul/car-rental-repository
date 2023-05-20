package com.example.carrental.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ReturnDTO {

    private Integer employeeID;

    private Integer returnDate;

    private Integer reservationId;

    private Integer extraCharge;

    private String comments;

}
