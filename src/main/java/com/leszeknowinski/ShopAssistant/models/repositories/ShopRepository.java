package com.leszeknowinski.ShopAssistant.models.repositories;

import com.leszeknowinski.ShopAssistant.models.entities.ShopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Integer> {

    boolean existsByLogin(String login);

    Optional<ShopEntity> findByLoginAndPassword(String login, String password);

    Optional<ShopEntity> findById(int shopId);

    Optional<ShopEntity> findByNameContains(String search);

}
