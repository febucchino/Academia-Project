package com.example.academia.entity;

import javax.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plano_assinatura")
public class SubscriptionPlan {

    @Id
    @Column(name = "id_plano_assinatura")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "tipo_assinatura")
    private String subscriptionType;

    @Column(name = "duracao")
    private String duration;

    @Column(name = "preco")
    private Float price;

}
