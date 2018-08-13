package com.leszeknowinski.ShopAssistant.models.forms;

import lombok.Data;

@Data
public class BarcodeForm {
    private int shopId;
    private String barcode;
}
