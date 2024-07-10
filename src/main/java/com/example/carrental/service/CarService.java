package com.example.carrental.service;

import com.example.carrental.controller.DTO.CarDTO;
import com.example.carrental.controller.DTO.DepartmentDTO;
import com.example.carrental.repository.model.CarModel;
import com.example.carrental.repository.model.CarStatus;
import com.example.carrental.repository.model.CarStatusHistoryModel;
import com.example.carrental.service.mapper.CarMapper;
import com.example.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CurrencyService currencyService;
    private final DistanceService distanceService;


    public UUID addCar(CarDTO carDTO) {
        CarModel newCar = new CarModel();
        carMapper.carDTOToCarModel(carDTO, newCar);
        carRepository.save(newCar);
        return newCar.getId();
    }

    public UUID deleteCar(UUID id) {
        carRepository.deleteById(id);
        return id;
    }

    public UUID editCar(UUID id, CarDTO carDTO) {
        CarModel carModel = carRepository.findById(id).orElse(null);
        carMapper.carDTOToCarModel(carDTO, carModel);
        carRepository.save(carModel);
        return id;
    }

    public CarStatus getCarStatusOnGivenDay(LocalDate date, UUID id) {
        CarModel carModel = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong id"));
            List<CarStatusHistoryModel> statusHistoryModelsOfAGivenCar = carModel.getCarStatusHistoryModels();
            statusHistoryModelsOfAGivenCar
                    .stream()
                    .filter(s -> s.getStartDate().isBefore(date) && s.getEndDate().isAfter(date));

            if (statusHistoryModelsOfAGivenCar.isEmpty()) {
                return CarStatus.AVAILABLE;
            }

            return CarStatus.RESERVED;
    }

    public CarStatus getCarAvailabilityInAGivenPeriod (CarModel carModel, LocalDate startDate, LocalDate endDate) {
        List<CarStatusHistoryModel> carStatusHistoryModelList = carModel.getCarStatusHistoryModels();
        carStatusHistoryModelList
                .stream()
                .filter(s -> s.getStartDate().isAfter(startDate) && s.getStartDate().isBefore(endDate) ||
                        s.getEndDate().isAfter(startDate) && s.getEndDate().isBefore(endDate) ||
                        s.getStartDate().isBefore(startDate) && s.getEndDate().isAfter(endDate))
                .collect(Collectors.toList());

        if (carStatusHistoryModelList.isEmpty()) {
            return CarStatus.AVAILABLE;
        }

        return CarStatus.RESERVED;
    }

    public List<CarDTO> getAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(carMapper::carModelToCarDTO)
                .collect(Collectors.toList());
    }

        public HashMap<CarDTO, Double> getAllCarsAsMap() {


            HashMap<CarDTO, Double> map =carRepository
                .findAll()
                .stream()
                .map(carMapper::carModelToCarDTO)
                .collect(Collectors.toMap(carDTO -> carDTO,
                        CarDTO::getPricePerDay,
                        (existing, replacement) -> existing,
                        HashMap::new ));

        return map;
    }



    public CarDTO getCarDTOById(UUID id) {
        CarModel carModel = carRepository.findById(id).orElse(null);
        return carMapper.carModelToCarDTO(carModel);
    }

    public Double getInitialCost(CarDTO carDTO, LocalDate startDate, LocalDate endDate) {
        return carDTO.getPricePerDay()*(endDate.compareTo(startDate));
    }


    public Double getRentingPrice(CarDTO carDTO, LocalDate startDate, LocalDate endDate,
                                  String startDepartment, String endDepartment, String currency){
        double period = endDate.compareTo(startDate);
        double ratio = currencyService.getConvertRatio(currency);
        double rentingPrice = carDTO.getPricePerDay()*period;
        double returnPrice = distanceService.getDistanceBetweenDepartments(startDepartment, endDepartment)*
                carDTO.getPricePerKm();

        return (rentingPrice + returnPrice) * ratio;
    }



    public List<CarWithPrice> getAllAvailableCars(LocalDate startDate, LocalDate endDate, String currency,
                                                  String startDepartment, String endDepartment) {


                return carRepository
                            .findAll()
                            .stream()
                            .filter(c -> getCarAvailabilityInAGivenPeriod(c, startDate, endDate)
                                    .equals(CarStatus.AVAILABLE))
                            .map(carMapper::carModelToCarDTO)
                            .map(carDTO -> new CarWithPrice(carDTO, getRentingPrice(carDTO,startDate, endDate,
                                    startDepartment,endDepartment, currency)))
                            .collect(Collectors.toList());
    }

    public static class CarWithPrice {
        private final CarDTO carDTO;
        private final Double price;

        public CarDTO getCarDTO() {
            return carDTO;
        }

        public Double getPrice() {
            return price;
        }

        public CarWithPrice(CarDTO carDTO, Double price) {
            this.carDTO = carDTO;
            this.price = price;
        }
    }


}
