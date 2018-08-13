package com.leszeknowinski.ShopAssistant.models.services;


import com.leszeknowinski.ShopAssistant.models.entities.BarcodeEntity;
import com.leszeknowinski.ShopAssistant.models.repositories.BarcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarcodeService {

    @Autowired
    BarcodeRepository barcodeRepository;

    public void saveBarcode(String barcode, int shopId){
        BarcodeEntity newBarcode = new BarcodeEntity();
        newBarcode.setReceiptBarcode(barcode);
        newBarcode.setShopId(shopId);
        barcodeRepository.save(newBarcode);
    }
}
