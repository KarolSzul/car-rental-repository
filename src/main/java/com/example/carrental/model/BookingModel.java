package com.example.carrental.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn (name = "employee_model")
    private EmployeeModel employeeModel;

    @Column (name = "booking_start_day")
    private LocalDate bookingStartDay;

    @Column(name = "comments")
    private String comments;


}
