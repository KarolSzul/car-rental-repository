package com.example.carrental.controller;

import com.example.carrental.controller.DTO.CarStatusHistoryDTO;
import com.example.carrental.controller.DTO.ReservationDTO;
import com.example.carrental.controller.validation.ReservationDTOValidator;
import com.example.carrental.repository.model.CarStatus;
import com.example.carrental.repository.model.ReservationModel;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.service.CarStatusHistoryService;
import com.example.carrental.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reservations")
public class ReservationController {



    private final ReservationService reservationService;
    private final CarStatusHistoryService carStatusHistoryService;
    private final ReservationDTOValidator reservationDTOValidator;

    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(reservationDTOValidator);
    }

    @GetMapping("/getall")
    public List<ReservationDTO> getReservations() {
        return reservationService.getAllReservation();
    }

    @GetMapping("/get/{id}")
    public ReservationDTO getReservationById(@PathVariable ("id") UUID id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/customer/{id}")
    public List<ReservationDTO> getReservationsOfAGivenCustomer (@PathVariable("id") UUID id) {
        return reservationService.getReservationsOfAGivenCustomer(id);
    }

    @PostMapping("/add")
    public UUID addReservation(@Valid @RequestBody ReservationDTO reservationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid data input");
        }
        CarStatusHistoryDTO carStatusHistoryDTO =
                new CarStatusHistoryDTO(reservationDTO.getReservationStartDate()
                        , reservationDTO.getReservationEndDate(), CarStatus.RESERVED, reservationDTO.getCarModel());
        carStatusHistoryService.addCarStatusHistoryRecord(carStatusHistoryDTO);
        return reservationService.addReservation(reservationDTO);

    }



    @DeleteMapping("/delete/{id}")
    public UUID deleteReservationById(@PathVariable("id") UUID id) {
        return reservationService.deleteReservation(id);
    }


    @PutMapping("/edit/{id}")
    public UUID editReservation(@PathVariable("id") UUID id, @Valid @RequestBody ReservationDTO reservationDTO,
                                BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid data input");
        }
        return reservationService.editReservation(reservationDTO,id);

    }




}
