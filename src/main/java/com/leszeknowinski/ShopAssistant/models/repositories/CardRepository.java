package com.leszeknowinski.ShopAssistant.models.repositories;

import com.leszeknowinski.ShopAssistant.models.entities.CardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<CardEntity, Integer> {


    Optional<CardEntity> findByNumber(String number);

    Optional<CardEntity> findByCustomerId(int customerId);



}
