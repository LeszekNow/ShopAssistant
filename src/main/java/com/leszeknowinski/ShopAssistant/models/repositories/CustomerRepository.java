package com.leszeknowinski.ShopAssistant.models.repositories;

import com.leszeknowinski.ShopAssistant.models.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    boolean existsByLogin(String login);

    Optional<CustomerEntity> findByLoginAndPassword(String login, String password);

    Optional<CustomerEntity> findByLogin(String login);

    Optional<CustomerEntity> findById(int id);

}
