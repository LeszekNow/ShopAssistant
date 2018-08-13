package com.leszeknowinski.ShopAssistant.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter @Setter
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String email;
    @Column(name = "is_card_active")
    private boolean isCardActive;
    private String login;
    private String password;


//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    private CardEntity card;
}
