package com.example.carrental.service;

import com.example.carrental.controller.DTO.CustomerDTO;
import com.example.carrental.service.mapper.CustomerMapper;
import com.example.carrental.repository.model.CustomerModel;
import com.example.carrental.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::customerModelToCustomerDTO)
                .collect(Collectors.toList());
    }

    public UUID addCustomer(CustomerDTO customerDTO) {
        CustomerModel newCustomer = new CustomerModel();
        customerMapper.customerDtoToCustomerModel(customerDTO,newCustomer);
        customerRepository.save(newCustomer);
        return newCustomer.getId();
    }

    public UUID deleteCustomerById(UUID id) {
        customerRepository.deleteById(id);
        return id;
    }

    public CustomerDTO getCustomerById(UUID id) {
        CustomerModel customerModel = customerRepository.findById(id).orElse(null);
        return customerMapper.customerModelToCustomerDTO(customerModel);
    }

    public UUID editCustomer(CustomerDTO customerDTO, UUID id) {
        CustomerModel customerModel = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));;
        customerMapper.customerDtoToCustomerModel(customerDTO, customerModel);
        customerRepository.save(customerModel);
        return id;
    }
}
