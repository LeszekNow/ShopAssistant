package com.leszeknowinski.ShopAssistant.models.controllers;

import com.leszeknowinski.ShopAssistant.models.forms.ReceiptForm;
import com.leszeknowinski.ShopAssistant.models.forms.ReclamationForm;
import com.leszeknowinski.ShopAssistant.models.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TerminalController {

    @Autowired
    CardService cardService;

    @Autowired
    ReceiptService receiptService;

    @Autowired
    ProductService productService;

    @Autowired
    ShopService shopService;

    @Autowired
    BarcodeService barcodeService;

    @GetMapping("/shop/terminal")
    public String terminal(Model model) {
        model.addAttribute("receiptForm", new ReceiptForm());
        return "terminal";
    }

    @PostMapping("/shop/terminal")
    public String terminal(@ModelAttribute ReceiptForm receiptForm, Model model){
        String barcode = receiptService.generateBarcode();
        receiptService.createReceipt(receiptForm, barcode, cardService.getCardRepository().findByNumber(receiptForm.getCardNumber()).get().getId(), shopService.getShopData().getId());
        cardService.addPoints(receiptForm.getCardNumber(), productService.getPoints(cardService.splitStringByComma(receiptForm.getProductBarcode()), shopService.getShopData().getId()));
        barcodeService.saveBarcode(barcode, shopService.getShopData().getId());
        model.addAttribute("info", "Receipt saved in DB!");
        return "redirect:/shop/terminal";
    }

    @GetMapping("/shop/reclamation")
    public String reclamation(Model model){
        model.addAttribute("reclamationForm", new ReceiptForm());
        return "reclamation";
    }

    @PostMapping("/shop/reclamation")
    public String reclamation(@ModelAttribute ReclamationForm reclamationForm, Model model){
        model.addAttribute("receipts", receiptService.getReceiptRepository().findByCardIdAndShopId(cardService.getCardRepository().findByNumber(reclamationForm.getCardNumber()).get().getId(), shopService.getShopData().getId()));
        return "reclamation";
    }
}