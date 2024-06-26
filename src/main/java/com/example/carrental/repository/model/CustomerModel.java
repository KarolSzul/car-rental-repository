package com.example.carrental.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "first_name")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    @Size(max = 100, message = "{validation.name.size.too_long}")
    private String address;
    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRentalModel carRentalModel;
    @OneToMany(mappedBy = "customerModel")
    private Set<ReservationModel> reservationModelSet;

}
