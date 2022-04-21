package com.emu.bank_service.service;

import com.emu.bank_service.models.Bank;
import com.emu.bank_service.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BankService {
    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Transactional
    public Bank changeAuthMethod(Bank bank, String authMethod){
        if (bankRepository.findById(bank.getId()).isPresent()){
            bank.setPreferredAuthType(authMethod);
        } else {
            throw new IllegalStateException("Account does not exist");
        }
        return bank;
    }

}
