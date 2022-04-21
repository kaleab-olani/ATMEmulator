package com.emu.bank_service.models;

import javax.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_id",
            sequenceName = "account_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_id"
    )
    private Integer id;
    private Double amount;
    @OneToOne(cascade= CascadeType.PERSIST) private Bank bank;

    public Account() {
    }

    public Account(Double amount, Bank bank) {
        this.amount = amount;
        this.bank = bank;
    }

    public Account(Integer id, Double amount, Bank bank) {
        this.id = id;
        this.amount = amount;
        this.bank = bank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
