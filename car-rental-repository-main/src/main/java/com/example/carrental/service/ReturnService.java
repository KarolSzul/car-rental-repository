package com.example.carrental.service;

import com.example.carrental.DTO.ReturnDTO;
import com.example.carrental.mapper.ReturnMapper;
import com.example.carrental.model.ReturnModel;
import com.example.carrental.repository.ReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnService {

    private final ReturnRepository returnRepository;

    private final ReturnMapper returnMapper;

    public List<ReturnModel> getAllReturns() { return returnRepository.findAll(); }

    public ReturnModel getReturnModelById(Long id) { return returnRepository.findById(id).orElse(null); }


    public void addReturn(ReturnDTO returnDTO) {
        ReturnModel newReturn = new ReturnModel();
        returnMapper.returnDTOToReturnModel(returnDTO, newReturn);
        returnRepository.save(newReturn);
    }

    public void deleteReturn(Long id) { returnRepository.deleteById(id); }

    public void editReturn(ReturnDTO returnDTO, ReturnModel editedReturnModel) {
        returnMapper.returnDTOToReturnModel(returnDTO, editedReturnModel);
        returnRepository.save(editedReturnModel);
    }


}
