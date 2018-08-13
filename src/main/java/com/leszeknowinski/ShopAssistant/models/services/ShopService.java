package com.leszeknowinski.ShopAssistant.models.services;


import com.leszeknowinski.ShopAssistant.models.entities.ShopEntity;
import com.leszeknowinski.ShopAssistant.models.forms.ShopForm;
import com.leszeknowinski.ShopAssistant.models.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class ShopService {

    private ShopEntity shopData;
    private boolean isLogged;

    public ShopEntity getShopData() {
        return shopData;
    }

    public void setShopData(ShopEntity shopData) {
        this.shopData = shopData;
    }

    public boolean isLogged(){
        return isLogged;
    }

    @Autowired
    ShopRepository shopRepository;

    public boolean register(ShopForm shopForm){
        ShopEntity newShop = new ShopEntity();
        newShop.setName(shopForm.getName());
        newShop.setNip(shopForm.getNip());
        newShop.setAddress(shopForm.getAddress());
        newShop.setEmail(shopForm.getAddress());
        newShop.setLogin(shopForm.getLogin());
        newShop.setPassword(shopForm.getPassword());
        shopRepository.save(newShop);
        return true;
    }

    public Optional<ShopEntity> getShop(int shopId){
        return shopRepository.findById(shopId);
    }

    public boolean isShopExistsByLogin(String login){
        return shopRepository.existsByLogin(login);
    }

    public boolean authenticate(String login, String password){
        Optional<ShopEntity> loggedShop = shopRepository.findByLoginAndPassword(login, password);
        if(loggedShop.isPresent()){
            isLogged = true;
            shopData = loggedShop.get();
        }
        return loggedShop.isPresent();
    }

}
