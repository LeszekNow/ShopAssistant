package com.leszeknowinski.ShopAssistant.models.controllers;

import com.leszeknowinski.ShopAssistant.models.forms.CustomerForm;
import com.leszeknowinski.ShopAssistant.models.forms.LoginForm;
import com.leszeknowinski.ShopAssistant.models.services.CardService;
import com.leszeknowinski.ShopAssistant.models.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccessController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CardService cardService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registrationForm", new CustomerForm());
        return "registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute CustomerForm customerForm, Model model) {
        if (customerService.isCustomerExistByLogin(customerForm.getLogin())) {
            model.addAttribute("info", "This login is arrested!");
            return "registration";
        }
        customerService.register(customerForm);
        model.addAttribute("infoTwo", "Registered successfully!");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, Model model){
        if(!customerService.authenticate(loginForm.getLogin(), loginForm.getPassword())){
            model.addAttribute("infoThree", "Invalid card number or password!");
            return "login";
        }
        return "redirect:/homepage";
    }

}

