package com.leszeknowinski.ShopAssistant.models.repositories;

import com.leszeknowinski.ShopAssistant.models.entities.BarcodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcodeRepository extends CrudRepository<BarcodeEntity, Integer> {
}
