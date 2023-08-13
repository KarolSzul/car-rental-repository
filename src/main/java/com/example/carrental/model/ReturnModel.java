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
public class ReturnModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_model")
    private EmployeeModel employeeModel;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @OneToOne
    @JoinColumn(name = "reservation_model")
    private ReservationModel reservationModel;

    @Column(name = "extra_charge")
    private Integer extraCharge;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customer_model_id")
    private CustomerModel customerModel;


}
