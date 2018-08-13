package com.leszeknowinski.ShopAssistant.models.forms;

import lombok.Data;

@Data
public class ProductForm {
    private int shopId;
    private String barcode;
    private String name;
    private String description;
    private float price;
}
