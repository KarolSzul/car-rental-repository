package com.example.carrental.service;

import com.example.carrental.controller.DTO.ReservationDTO;
import com.example.carrental.service.mapper.ReservationMapper;
import com.example.carrental.repository.model.CarModel;
import com.example.carrental.repository.model.ReservationModel;
import com.example.carrental.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {


    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

    public UUID addReservation(ReservationDTO reservationDTO) {
        ReservationModel newReservation = new ReservationModel();
        reservationMapper.reservationDTOToReservationModel(reservationDTO, newReservation);
        reservationRepository.save(newReservation);
        return newReservation.getId();
    }

    public UUID deleteReservation(UUID id) {
        reservationRepository.deleteById(id);
        return id;
    }

    public UUID editReservation(ReservationDTO reservationDTO, UUID id) {
        ReservationModel reservationModel = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));;
        reservationMapper.reservationDTOToReservationModel(reservationDTO, reservationModel);
        reservationRepository.save(reservationModel);
        return reservationModel.getId();
    }

    public List<ReservationDTO> getAllReservation() {
        return reservationRepository
                .findAll()
                .stream()
                .map(reservationMapper::reservationModelToReservationDTO)
                .collect(Collectors.toList());
    }

    public List<ReservationDTO> getAllReservationOfAGivenCar (CarModel carModel) {
        return reservationRepository.findAll()
                .stream()
                .filter(r -> r.getCarModel().getId() == carModel.getId())
                .map(reservationMapper::reservationModelToReservationDTO)
                .collect(Collectors.toList());
    }

    public ReservationDTO getReservationById(UUID id) {
        ReservationModel reservationModel = reservationRepository.findById(id).orElse(null);
        return reservationMapper.reservationModelToReservationDTO(reservationModel);
    }

    public List <ReservationDTO> getReservationsOfAGivenCustomer(UUID id) {
        List<ReservationModel> reservationModelList = reservationRepository.getReservationModelByCustomerId(id);
        return reservationModelList
                .stream()
                .map(reservationMapper::reservationModelToReservationDTO)
                .collect(Collectors.toList());
    }



}


