package com.leszeknowinski.ShopAssistant.models.forms;

import lombok.Data;

@Data
public class CardForm {

    private int customerId;
    private int points;
    private String number;
    private boolean isActive;

}
