package com.example.academia.entity.dto;

import com.example.academia.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String name;
    private String cpf;
    private String email;
    private String telephone;
    private String registrationNumber;
    private Long subscriptionPlanId;

    public Customer toCustomer(){
        return new Customer(name, cpf, email, telephone, registrationNumber, subscriptionPlanId);
    }
}
