package com.example.academia.entity;

import com.example.academia.entity.dto.CustomerDTOResponse;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Customer {

    public Customer(String name, String cpf, String email, String telephone, String registrationNumber, Long subscriptionPlanId) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telephone = telephone;
        this.registrationNumber = registrationNumber;
        this.subscriptionPlanId = subscriptionPlanId;
    }

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telephone;

    @Column(name = "num_matricula")
    private String registrationNumber;

    @Column(name = "id_plano_assinatura")
    private Long subscriptionPlanId;

    public CustomerDTOResponse toDTO(){
        return CustomerDTOResponse.builder()
                .id(getId())
                .name(getName())
                .cpf(getCpf())
                .email(getEmail())
                .telephone(getTelephone())
                .registrationNumber(getRegistrationNumber())
                .subscriptionPlanId(getSubscriptionPlanId())
                .build();
    }
}
