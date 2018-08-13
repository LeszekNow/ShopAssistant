package com.leszeknowinski.ShopAssistant.models.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "card")
@Getter @Setter
@NoArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "customer_id")
    private int customerId;
    private int points;
    private String number;
    @Column(name = "is_active")
    private boolean isActive;
//    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ReceiptEntity>receipts;


//    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ReceiptEntity> receipts;
//
//    @OneToOne
//    @JoinColumn(name = "card_number")
//    private CustomerEntity customer;

}
