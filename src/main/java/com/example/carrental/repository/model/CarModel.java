package com.example.carrental.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "brand")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String brand;

    @Column(name="model")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String model;

    @Column(name = "body_type")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String bodyType;

    @Column(name = "color")
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String color;

    @Column(name = "year_of_production")
    private Integer yearOfProduction;

    @Column(name="mileage")
    private Integer mileage;

    @Column(name = "price_per_day")
    private Double pricePerDay;

    @OneToMany(mappedBy = "carModel")
    private List<CarStatusHistoryModel> carStatusHistoryModels;

    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRentalModel carRentalModel;


}
