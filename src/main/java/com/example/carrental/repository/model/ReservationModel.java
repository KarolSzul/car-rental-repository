package com.example.carrental.repository.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationModel {


    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "reservation_booking_date")
    private LocalDate reservationBookingDate;

    @Column(name = "reservation_start_date")
    private LocalDate reservationStartDate;

    @Column(name = "reservation_end_date")
    private LocalDate reservationEndDate;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "customer_model_id")
    private CustomerModel customerModel;

    @OneToOne
    @JoinColumn(name = "car_model_id")
    private CarModel carModel;

    @OneToOne
    @JoinColumn(name = "start_department_id")
    private DepartmentModel startDepartmentModel;


    @OneToOne
    @JoinColumn(name = "destination_department_model_id")
    private DepartmentModel destinationDepartmentModel;

//    @Embedded
    @OneToOne
    private BookingModel bookingModel;

//    @Embedded
    @OneToOne
    private ReturnModel returnModel;



}
