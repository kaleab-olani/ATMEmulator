package com.emu.bank_service.controller;

import com.emu.bank_service.models.Card;
import com.emu.bank_service.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/card")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public Card initCard(@RequestParam int cardNumber){
        return cardService.initCard(cardNumber);
    }

}
