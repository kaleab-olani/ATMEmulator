package com.emu.atm_service.model;

import javax.persistence.*;

@Entity
@Table
public class Card {
    @Id
    @SequenceGenerator(
            name = "card_id",
            sequenceName = "card_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "card_id"
    )
    private Integer id;
    private Integer cardNumber;
    @OneToOne(cascade=CascadeType.PERSIST)  private Account account;

    public Card() {
    }

    public Card(Integer cardNumber, Account account) {
        this.cardNumber = cardNumber;
        this.account = account;
    }

    public Card(Integer id, Integer cardNumber, Account account) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
