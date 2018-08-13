package com.leszeknowinski.ShopAssistant.models.controllers;

import com.leszeknowinski.ShopAssistant.models.entities.CustomerEntity;
import com.leszeknowinski.ShopAssistant.models.entities.ReceiptEntity;
import com.leszeknowinski.ShopAssistant.models.forms.CardForm;
import com.leszeknowinski.ShopAssistant.models.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomepageController {

    @Autowired
    CardService cardService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ReceiptService receiptService;

    @Autowired
    ShopService shopService;

    @Autowired
    ProductService productService;

    @GetMapping("/homepage")
    public String homepage(Model model) {
        if (!customerService.getCustomerData().isCardActive()) {
            model.addAttribute("info", "Register your card first!");
            return "redirect:/homepage/card/registration";
        } else {
            List<ReceiptEntity> allReceipts = new ArrayList<>();
            allReceipts.addAll(receiptService.getReceipts(cardService.getCardRepository().findByCustomerId(customerService.getCustomerData().getId()).get().getId()));
            model.addAttribute("receipts", allReceipts);
            model.addAttribute("customer", customerService.getCustomerData());
            model.addAttribute("card", cardService.getCardRepository().findByCustomerId(customerService.getCustomerData().getId()).get());
            return "homepage";
        }
    }

    @GetMapping("/homepage/card/registration")
    public String card(Model model) {
        model.addAttribute("cardRegisterForm", new CardForm());
        return "cardRegistration";
    }

    @PostMapping("/homepage/card/registration")
    public String card(@ModelAttribute CardForm cardForm, Model model) {
        cardService.registerCard(cardForm, customerService.getCustomerData().getId());
        CustomerEntity updatedCustomer = customerService.getCustomerData();
        updatedCustomer.setCardActive(true);
        customerService.getCustomerRepository().save(updatedCustomer);
        model.addAttribute("cardInfo", "Card registered successfully!");
        return "redirect:/homepage";
    }

    @GetMapping("/receipt/{id}/{shopId}")
    public String receipt(@PathVariable("id") int id, @PathVariable("shopId") int shopId, Model model) {
        model.addAttribute("products", productService.getProducts(cardService.splitStringByComma(receiptService.
                getReceipt(id).orElseThrow(IllegalStateException::new).getProductBarcode()), shopId));
        model.addAttribute("bars", cardService.splitStringByComma(receiptService.getReceipt(id).get().getProductBarcode()));
        model.addAttribute("shop", shopService.getShop(shopId).get().getName());
        return "receipt";
    }

    @PostMapping("/homepage/search/receipt")
    public String search(@RequestParam("search") String search, Model model){
        List<ReceiptEntity> allReceipts = new ArrayList<>();
        allReceipts.addAll(receiptService.getReceipts(cardService.getCardRepository().findByCustomerId(customerService.getCustomerData().getId()).get().getId()));
        List<ReceiptEntity> searchReceipts = new ArrayList<>();
        for(ReceiptEntity rec : allReceipts){
            if(shopService.getShop(rec.getShopId()).get().getName().toLowerCase().contains(search.toLowerCase())){
                searchReceipts.add(rec);
            }
        }
        model.addAttribute("receipts", searchReceipts);
        model.addAttribute("customer", customerService.getCustomerData());
        model.addAttribute("card", cardService.getCardRepository().findByCustomerId(customerService.getCustomerData().getId()).get());
        return "homepage";
    }


}
