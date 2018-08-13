package com.leszeknowinski.ShopAssistant.models.services;

import com.leszeknowinski.ShopAssistant.models.entities.CardEntity;
import com.leszeknowinski.ShopAssistant.models.entities.CustomerEntity;
import com.leszeknowinski.ShopAssistant.models.forms.CardForm;
import com.leszeknowinski.ShopAssistant.models.repositories.CardRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
public class CardService {

    @Autowired
    CardRepository cardRepository;


    public void registerCard(CardForm cardForm, int customerId){
        cardRepository.findByNumber(cardForm.getNumber()).get().setActive(true);
        cardRepository.findByNumber(cardForm.getNumber()).get().setCustomerId(customerId);
    }

    public void addPoints(String cardNumber, int points){
        CardEntity updatedCard = cardRepository.findByNumber(cardNumber).get();
        int current = updatedCard.getPoints();
        updatedCard.setPoints(current + points);
        cardRepository.save(updatedCard);
        }

    public String[] splitStringByComma(String barcodes) {
        return barcodes.split(",", -1);

    }

    public int getCollectedPoints(String cardNumber){
        return cardRepository.findByNumber(cardNumber).get().getPoints();
    }


}
