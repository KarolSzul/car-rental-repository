package com.example.carrental.controller;

import com.example.carrental.DTO.CarStatusHistoryDTO;
import com.example.carrental.DTO.ReservationDTO;
import com.example.carrental.model.CarStatus;
import com.example.carrental.model.ReservationModel;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.service.CarStatusHistoryService;
import com.example.carrental.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reservation")
public class ReservationController {



    private final ReservationService reservationService;
    private final CarStatusHistoryService carStatusHistoryService;
    private final ReservationRepository reservationRepository;



    @GetMapping
    public List<ReservationModel> getReservations() {
        return reservationService.getAllReservation();
    }


    @PostMapping
    public void addReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.addReservation(reservationDTO);
        CarStatusHistoryDTO carStatusHistoryDTO =
                new CarStatusHistoryDTO(reservationDTO.getReservationStartDate()
                        , reservationDTO.getReservationEndDate(), CarStatus.RESERVED, reservationDTO.getCarModel());
        carStatusHistoryService.addCarStatusHistoryRecord(carStatusHistoryDTO);
    }



    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
    }


    @PostMapping("/edit/{id}")
    public void editReservation(@PathVariable("id") Long id, @RequestBody ReservationDTO reservationDTO){
        ReservationModel reservationModel = reservationService.getAllReservation().get(Math.toIntExact(id));
        reservationService.editReservation(reservationDTO,reservationModel);

    }

    @GetMapping("/myresevations/{id}")
    public List<ReservationModel> getReservationsOfAGivenCustomer (@PathVariable("id") Long id) {
    return reservationRepository.getReservationModelByCustomerId(id);
    }


}
