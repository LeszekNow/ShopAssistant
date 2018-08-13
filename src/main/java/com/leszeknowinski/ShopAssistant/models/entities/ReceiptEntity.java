package com.leszeknowinski.ShopAssistant.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "receipt")
@Getter @Setter
@NoArgsConstructor
public class ReceiptEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "shop_id")
    private int shopId;
    @Column(name = "card_id")
    private int cardId; //
    @Column(name = "receipt_barcode")
    private String receiptBarcode;
    @Column(name = "product_barcode")
    private String productBarcode;
    private Date date;

//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private ShopEntity shop;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "number")
//    private CardEntity card;


}
