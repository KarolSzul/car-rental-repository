package com.example.carrental.controller;

import com.example.carrental.controller.DTO.DistanceDTO;
import com.example.carrental.repository.model.City;
import com.example.carrental.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/distance")
public class DistanceController {

    private final DistanceService distanceService;

    @GetMapping("/get")
    public DistanceDTO getDistanceDTO() {
    return distanceService.getDistanceDTO();
    }

    @GetMapping("/get/start={startCity}end={endCity}")
    public Double calculateDistance(@PathVariable ("startCity") String startCity,
                                    @PathVariable ("endCity") String endCity) {
        return distanceService.getDistance(startCity, endCity);

    }

}
