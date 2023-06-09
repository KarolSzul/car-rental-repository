package com.example.carrental.controller;

import com.example.carrental.DTO.CustomerDTO;
import com.example.carrental.model.CustomerModel;
import com.example.carrental.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping
    public List<CustomerModel> getCustomer() {
        // CustomerDTO test = new CustomerDTO("Maciej", "Minorowski", "testEmail","testAddress");
        // customerService.addCustomer(test);
        return customerService.getAllCustomers();

    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
    }

    @PostMapping("/edit/{id}")
    public void editCustomer(@PathVariable("id") Long id,@RequestBody CustomerDTO customerDTO){
        CustomerModel customerModel = customerService.getCustomerById(id);
        customerService.editCustomer(customerDTO, customerModel);
    }



}
