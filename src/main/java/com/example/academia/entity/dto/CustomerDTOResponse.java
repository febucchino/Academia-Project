package com.example.academia.entity.dto;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTOResponse {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String telephone;
    private String registrationNumber;
    private Long subscriptionPlanId;
}
