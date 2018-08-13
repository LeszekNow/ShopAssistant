package com.leszeknowinski.ShopAssistant.models.repositories;

import com.leszeknowinski.ShopAssistant.models.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    Optional<ProductEntity> findByBarcodeAndShopId(String barcode, int shopId);

    //Optional<ProductEntity> findByProductBarcodeAnAndShopId(String barcode, int shopId);


    //ProductEntity findByBarcodeAndShopId(String barcode, int shipId);


}
