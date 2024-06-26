package com.example.carrental.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Embeddable
public class ReturnModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

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
    @Size(max = 250, message = "{validation.name.size.too_long}")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customer_model_id")
    private CustomerModel customerModel;


}
