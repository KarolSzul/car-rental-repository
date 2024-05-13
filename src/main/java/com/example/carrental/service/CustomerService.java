package com.example.carrental.service;

import com.example.carrental.DTO.CustomerDTO;
import com.example.carrental.mapper.CustomerMapper;
import com.example.carrental.model.CustomerModel;
import com.example.carrental.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(CustomerDTO customerDTO) {
        CustomerModel newCustomer = new CustomerModel();
        customerMapper.customerDtoToCustomerModel(customerDTO,newCustomer);
        customerRepository.save(newCustomer);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerModel getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void editCustomer(CustomerDTO customerDTO, CustomerModel editedCustomerModel) {
        customerMapper.customerDtoToCustomerModel(customerDTO, editedCustomerModel);
        customerRepository.save(editedCustomerModel);
    }
}
