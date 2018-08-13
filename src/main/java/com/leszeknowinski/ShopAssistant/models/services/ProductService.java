package com.leszeknowinski.ShopAssistant.models.services;

import com.leszeknowinski.ShopAssistant.models.entities.ProductEntity;
import com.leszeknowinski.ShopAssistant.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public int getPoints(String[]barcodes, int shopId){
        int sum = 0;
        for(String barcode : barcodes){
            sum += productRepository.findByBarcodeAndShopId(barcode.trim(), shopId).get().getPrice();
        }
       return sum;
    }

    public List<Optional<ProductEntity>> getProducts(String[]barcodes, int shopId){
        List<Optional<ProductEntity>>products = new ArrayList<>();
        for(String barcode : barcodes){
            products.add(productRepository.findByBarcodeAndShopId(barcode.trim(), shopId));
        }
        return products;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    //JSON parser
    //barcode splitting by ','
}
