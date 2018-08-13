package com.leszeknowinski.ShopAssistant.models.forms;


import lombok.Data;

@Data
public class ReceiptForm {
    private int shopId;
    private String cardNumber;
    private String receiptBarcode;
    private String productBarcode; // barcode, barcode, barcode

}
