package com.leszeknowinski.ShopAssistant.models.controllers;

import com.leszeknowinski.ShopAssistant.models.forms.ShopForm;
import com.leszeknowinski.ShopAssistant.models.forms.ShopLoginForm;
import com.leszeknowinski.ShopAssistant.models.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopAccessController {

    @Autowired
    ShopService shopService;

    @GetMapping("/shop/register")
    public String register(Model model) {
        model.addAttribute("shopRegistrationForm", new ShopForm());
        return "shopRegistration";
    }

    @PostMapping("/shop/register")
    public String register(@ModelAttribute ShopForm shopForm, Model model) {
        if (shopService.isShopExistsByLogin(shopForm.getLogin())) {
            model.addAttribute("info", "This login is arrested!");
            return "shopRegistration";
        }
        shopService.register(shopForm);
        model.addAttribute("infoTwo", "Shop registered successfully!");
        return "redirect:/shop/login";
    }

    @GetMapping("/shop/login")
    public String login(Model model) {
        model.addAttribute("shopLoginForm", new ShopForm());
        return "shopLogin";
    }

    @PostMapping("/shop/login")
    public String login(@ModelAttribute ShopLoginForm shopLoginForm, Model model){
        if(!shopService.authenticate(shopLoginForm.getLogin(), shopLoginForm.getPassword())){
            model.addAttribute("infoThree", "Invalid login or password!");
            return "shopLogin";
        }
        return "redirect:/shop/terminal";
    }

}
