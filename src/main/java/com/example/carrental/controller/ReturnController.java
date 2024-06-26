package com.example.carrental.controller;

import com.example.carrental.controller.DTO.ReturnDTO;
import com.example.carrental.controller.validation.ReturnDTOValidator;
import com.example.carrental.repository.model.ReservationModel;
import com.example.carrental.repository.model.ReturnModel;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.service.BillingService;
import com.example.carrental.service.ReservationService;
import com.example.carrental.service.ReturnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/returns")
public class ReturnController {

    private final ReturnService returnService;
    private final BillingService billingService;
    private final ReturnDTOValidator returnDTOValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(returnDTOValidator);
    }

    @GetMapping("/getall")
    public List<ReturnDTO> getReturns(){
        return returnService.getAllReturns();
    }

    @PostMapping("/add/{id}")
    public UUID addReturn (@Valid @RequestBody ReturnDTO returnDTO, @PathVariable UUID id,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid data input");
        }
        returnService.addReturn(returnDTO, id);
        return id;
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteReturnById(@PathVariable("id") UUID id) { return returnService.deleteReturn(id); }

    @PutMapping("/edit/{id}")
    public UUID editReturn(@PathVariable("id") UUID id, @Valid @RequestBody ReturnDTO returnDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid data input");
        }
        return returnService.editReturn(returnDTO, id);
    }

    @GetMapping("/getcost/{id}")
    public Double getTotalCostOfRenting(@PathVariable("id") UUID id) {
        return billingService.getFinalCost(id);
    }


}
