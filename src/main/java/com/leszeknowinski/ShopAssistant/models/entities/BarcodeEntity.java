package com.leszeknowinski.ShopAssistant.models.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "barcode")
@Data
public class BarcodeEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "shop_id")
    private int shopId;
    @Column(name = "receipt_barcode")
    private String receiptBarcode;
}
