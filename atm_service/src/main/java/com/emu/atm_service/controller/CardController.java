package com.emu.atm_service.controller;

import com.emu.atm_service.model.Card;
import com.emu.atm_service.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/card")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(path = "{card_number}")
    public Card initCard(@PathVariable("card_number") int cardNumber){
        return cardService.initCard(cardNumber);
    }

}
