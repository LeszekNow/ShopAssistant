package com.leszeknowinski.ShopAssistant.models.repositories;

import com.leszeknowinski.ShopAssistant.models.entities.ReceiptEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends CrudRepository<ReceiptEntity, Integer> {

    List<ReceiptEntity> findByCardId(int cardId);
    List<ReceiptEntity> findByCardIdAndShopId(int cardId, int shopId);

}
