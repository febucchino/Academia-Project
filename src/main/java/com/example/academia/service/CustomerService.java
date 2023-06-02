package com.example.academia.service;

import com.example.academia.entity.Customer;
import com.example.academia.entity.dto.CustomerDTO;
import com.example.academia.entity.dto.CustomerDTOResponse;
import com.example.academia.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDTOResponse> findAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> CustomerDTOResponse
                        .builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .cpf(customer.getCpf())
                        .email(customer.getEmail())
                        .telephone(customer.getTelephone())
                        .registrationNumber(customer.getRegistrationNumber())
                        .subscriptionPlanId(customer.getSubscriptionPlanId())
                        .build())
                .collect(Collectors.toList());
    }

    public CustomerDTOResponse createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerDTO.toCustomer();
        return customerRepository.save(customer).toDTO();

    }

    public List<CustomerDTOResponse> findCustomerById(Long id) {
        return customerRepository.findById(id)
                .stream()
                .map(customer -> CustomerDTOResponse
                        .builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .cpf(customer.getCpf())
                        .email(customer.getEmail())
                        .telephone(customer.getTelephone())
                        .registrationNumber(customer.getRegistrationNumber())
                        .subscriptionPlanId(customer.getSubscriptionPlanId())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateCustomerById(Long id, CustomerDTO customerDTO) {
        customerRepository.findById(id)
                .map(customer -> Customer
                        .builder()
                        .id(id)
                        .name(customerDTO.getName())
                        .cpf(customerDTO.getCpf())
                        .email(customerDTO.getEmail())
                        .telephone(customerDTO.getTelephone())
                        .registrationNumber(customerDTO.getRegistrationNumber())
                        .subscriptionPlanId(customerDTO.getSubscriptionPlanId())
                        .build())
                .ifPresent(customerRepository::save);
    }

    @Transactional
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
