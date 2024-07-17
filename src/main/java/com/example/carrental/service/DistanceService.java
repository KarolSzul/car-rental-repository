package com.example.carrental.service;

import com.example.carrental.controller.DTO.DepartmentDTO;
import com.example.carrental.controller.DTO.DistanceDTO;
import com.example.carrental.repository.DepartmentRepository;
import com.example.carrental.repository.model.City;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceService {

    private RestTemplate restTemplate;

    public DepartmentRepository departmentRepository;

    public DistanceService(DepartmentRepository departmentRepository) {
        this.restTemplate = new RestTemplate();
        this.departmentRepository = departmentRepository;
    }

    public String getUrl(Double startLatitude, Double startLongitude,
                         Double endLatitude, Double endLongitude) {
        String customUrl = "https://api-v2.distancematrix.ai/maps/api/distancematrix" +
                "/json?origins=%s,%s&destinations=%s,%s" +
                "&key=imJ4E7wnpOLLYLXlzWBGuqwvnmKfRScBwYoAHGI2gDWDqOoqWbMBOrzfNVkm7NQ2";
        return String.format(customUrl, startLatitude, startLongitude, endLatitude, endLongitude);
    } // do properties


    public DistanceDTO getDistanceDTO() {
        return restTemplate
                .getForObject("https://api-v2.distancematrix.ai/maps/api/distancematrix/json?" +
                        "origins=51.107883,17.038538&" +
                        "destinations=52.237049,21.017532" +
                        "&key=imJ4E7wnpOLLYLXlzWBGuqwvnmKfRScBwYoAHGI2gDWDqOoqWbMBOrzfNVkm7NQ2"
                        , DistanceDTO.class);
    }

    public DistanceDTO getDistanceDTO(String url) {
        return restTemplate
                .getForObject(url
                        , DistanceDTO.class);
    }

    public Double convertMToKm (int meters) {
        return (double) meters/1000;
    }

    public Double getDistanceFromDTO (DistanceDTO distanceDTO) {
        DistanceDTO.Rows[] rows = distanceDTO.getRows();
        DistanceDTO.Rows.Elements[] elements =rows[0].getElements();
        int meters = elements[0].getDistance().getValue();
        return convertMToKm(meters);
    }

    public Double getDistance (String startCity, String endCity) {
        City newStartCity = City.valueOf(startCity.toUpperCase());
        City newEndCity = City.valueOf(endCity.toUpperCase());
        String url = getUrl(newStartCity.getLatitude(), newStartCity.getLongitude(),
                newEndCity.getLatitude(), newEndCity.getLongitude());

        DistanceDTO distanceDTO = getDistanceDTO(url);

        return getDistanceFromDTO(distanceDTO);

    }

    public Double getDistanceBetweenDepartments (DepartmentDTO startDepartment, DepartmentDTO endDepartment) {
        City newStartCity = startDepartment.getCity();
        City newEndCity = endDepartment.getCity();
        String url = getUrl(newStartCity.getLatitude(), newStartCity.getLongitude(),
                newEndCity.getLatitude(), newEndCity.getLongitude());

        DistanceDTO distanceDTO = getDistanceDTO(url);

        return getDistanceFromDTO(distanceDTO);

    }

    public Double getDistanceBetweenDepartments (String startDepartment, String endDepartment) {
        City startCity = departmentRepository.getByAlias(startDepartment).getCity();
        City endCity = departmentRepository.getByAlias(endDepartment).getCity();

        String url = getUrl(startCity.getLatitude(), startCity.getLongitude(),
                endCity.getLatitude(), endCity.getLongitude());

        DistanceDTO distanceDTO = getDistanceDTO(url);

        return getDistanceFromDTO(distanceDTO);
    }



}
