package com.leszeknowinski.ShopAssistant.models.services;


import com.leszeknowinski.ShopAssistant.models.entities.ReceiptEntity;
import com.leszeknowinski.ShopAssistant.models.forms.ReceiptForm;
import com.leszeknowinski.ShopAssistant.models.repositories.CardRepository;
import com.leszeknowinski.ShopAssistant.models.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ReceiptService {

    @Autowired
    ReceiptRepository receiptRepository;


    public boolean createReceipt(ReceiptForm receiptForm, String barcode, int cardId, int shopId) {
        ReceiptEntity receipt = new ReceiptEntity();
        receipt.setShopId(shopId);
        receipt.setCardId(cardId);
        receipt.setReceiptBarcode(barcode);
        receipt.setProductBarcode(receiptForm.getProductBarcode());
        receiptRepository.save(receipt);
        return true;
    }

    public List<ReceiptEntity> getReceipts(int cardId) {
        return receiptRepository.findByCardId(cardId);

    }

    public Optional<ReceiptEntity> getReceipt(int id) {
        return receiptRepository.findById(id);
    }

    public String generateBarcode(){
        Random random = new Random();
        StringBuilder barcode = new StringBuilder();
        for(int i = 0; i < 13; i++){
            barcode.append(random.nextInt(((9 - 0) + 1) + 0));
        }
        return barcode.toString();
    }

    public ReceiptRepository getReceiptRepository() {
        return receiptRepository;
    }
}




