package com.example.carrental.service;

import com.example.carrental.controller.DTO.ReturnDTO;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.repository.model.ReservationModel;
import com.example.carrental.service.mapper.ReservationMapper;
import com.example.carrental.service.mapper.ReturnMapper;
import com.example.carrental.repository.model.ReturnModel;
import com.example.carrental.repository.ReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReturnService {
    private final ReturnRepository returnRepository;

    private final ReturnMapper returnMapper;
    private final ReservationRepository reservationRepository;

    public List<ReturnDTO> getAllReturns() {
        return returnRepository
                .findAll()
                .stream()
                .map(r -> returnMapper.returnModelToReturnDTO(r))
                .collect(Collectors.toList());
    }

    public ReturnDTO getReturnDTOById(UUID id) {
        ReturnModel returnModel = returnRepository.findById(id).orElse(null);
        return returnMapper.returnModelToReturnDTO(returnModel);
    }


    public UUID addReturn(ReturnDTO returnDTO, UUID id) {
        ReturnModel newReturn = new ReturnModel();
        returnMapper.returnDTOToReturnModel(returnDTO, newReturn);
        returnRepository.save(newReturn);
        ReservationModel reservationModel = reservationRepository.findById(id).orElse(null);
        reservationModel.setReturnModel(newReturn);
        return newReturn.getId();
    }

    public UUID deleteReturn(UUID id) {
        returnRepository.deleteById(id);
        return id;
    }

    public UUID editReturn(ReturnDTO returnDTO, UUID id) {
        ReturnModel returnModel = returnRepository.findById(id).orElse(null);
        returnMapper.returnDTOToReturnModel(returnDTO, returnModel);
        returnRepository.save(returnModel);
        return id;
    }
}
