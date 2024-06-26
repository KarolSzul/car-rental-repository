package com.example.carrental.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarStatusHistoryModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "start_date")
    @NonNull
    private LocalDate startDate;

    @Column(name = "end_date")
    @NonNull
    private LocalDate endDate;

    @Column(name = "car_status")
    @NonNull
    private CarStatus carStatus;

    @ManyToOne
    @JoinColumn (name = "car_model_id")
    private CarModel carModel;




}