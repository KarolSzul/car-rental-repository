package com.example.carrental.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Embeddable
public class BookingModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @OneToOne
    @JoinColumn (name = "employee_model")
    private EmployeeModel employeeModel;

    @Column (name = "booking_start_day")
    @NotBlank(message = "Please define a valid date")
    private LocalDate bookingStartDay;

    @Column(name = "comments")
    @Size(max = 500, message = "{validation.name.size.too_long}")
    private String comments;


}
