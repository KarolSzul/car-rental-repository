package com.example.carrental.controller;

import com.example.carrental.controller.DTO.CustomerDTO;
import com.example.carrental.controller.validation.CustomerDTOValidator;
import com.example.carrental.repository.model.CustomerModel;
import com.example.carrental.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDTOValidator customerDTOValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(customerDTOValidator);
    }


    @GetMapping
    public List<CustomerDTO> getCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/{id}")
    public CustomerDTO getCustomerById(@PathVariable UUID id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/add")
    public UUID addCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid data input");
        }
        return customerService.addCustomer(customerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteCustomerById(@PathVariable("id") UUID id){
        return customerService.deleteCustomerById(id);
    }

    @PutMapping("/edit/{id}")
    public UUID editCustomer(@PathVariable("id") UUID id,@Valid @RequestBody CustomerDTO customerDTO,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new IllegalArgumentException("Invalid data input");
        }
        return customerService.editCustomer(customerDTO, id);
    }



}
