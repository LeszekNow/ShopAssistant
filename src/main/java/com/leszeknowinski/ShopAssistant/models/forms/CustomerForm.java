package com.leszeknowinski.ShopAssistant.models.forms;

import lombok.Data;

@Data
public class CustomerForm {
    private String name;
    private String surname;
    private String email;
    private boolean isCardActive;
    private String login;
    private String password;

}
