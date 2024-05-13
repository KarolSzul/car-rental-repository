package com.example.carrental.controller;

import com.example.carrental.DTO.ReturnDTO;
import com.example.carrental.model.BookingModel;
import com.example.carrental.model.ReturnModel;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.service.BillingService;
import com.example.carrental.service.ReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/returns")
public class ReturnController {

    private final ReturnService returnService;

    private final BillingService billingService;
    private final ReservationRepository reservationRepository;

    @GetMapping
    public List<ReturnModel> getReturns(){
        return returnService.getAllReturns();

    }

    @PostMapping("/{id}")
    public void addReturn (@RequestBody ReturnDTO returnDTO, @PathVariable Long id) {
        ReturnModel returnModel = returnService.addReturn(returnDTO);
        reservationRepository.getReservationModelById(id).setReturnModel(returnModel);
    }

    @DeleteMapping("/{id}")
    public void deleteReturnById(@PathVariable("id") Long id) { returnService.deleteReturn(id); }

    @PutMapping("/{id}")
    public void editReturn(@PathVariable("id") Long id,@RequestBody ReturnDTO returnDTO) {
        ReturnModel returnModel = returnService.getReturnModelById(id);
        returnService.editReturn(returnDTO, returnModel);
    }

    @GetMapping("/getcost/{id}")
    public Double getTotalCostOfRenting(@PathVariable("id") Long id) {
        return billingService.getFinalCost(id);
    }


}
