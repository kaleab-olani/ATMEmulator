package com.emu.bank_service.service;

import com.emu.bank_service.models.Card;
import com.emu.bank_service.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getCards(){
        return cardRepository.findAll();
    }

    public void createCard(Card card) {
        Optional<Card> cardByCardNumber = cardRepository.findCardByCardNumber(card.getCardNumber());
        if (cardByCardNumber.isPresent()){
            throw new IllegalStateException("Card number already exists.");
        } else {
            cardRepository.save(card);
        }
    }

    public void deleteCard(Integer cardId) {
        Optional<Card> card = cardRepository.findById(cardId);
        if (card.isPresent()){
            cardRepository.delete(card.get());
        } else {
            throw new IllegalStateException("Card not found.");
        }
    }
    public Card initCard(Integer cardNumber) {
        Optional<Card> card = cardRepository.findCardByCardNumber(cardNumber);
        return card.orElse(null);
    }

    @Transactional
    public void updateCard(Integer cardId, Integer cardNumber) {
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new IllegalStateException("Card with ID " + cardId + "does nt exist"));
        cardRepository.findCardByCardNumber(cardNumber).ifPresent(card1 -> {
            throw new IllegalArgumentException(String.format("A card with card number %d already exists", cardNumber));
        });
        if (cardNumber > 0 && !card.getCardNumber().equals(cardNumber)){
            card.setCardNumber(cardNumber);
        }
    }
}
