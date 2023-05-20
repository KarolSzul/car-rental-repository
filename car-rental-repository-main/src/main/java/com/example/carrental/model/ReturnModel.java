package com.example.carrental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "return_id")
    private Integer returnId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "return_date")
    private Integer returnDate;

    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "extra_charge")
    private Integer extraCharge;

    @Column(name = "comments")
    private String comments;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private ReservationModel reservationModel;



}
