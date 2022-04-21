package com.emu.bank_service.service;

import com.emu.bank_service.models.Account;
import com.emu.bank_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Transactional
    public boolean withdraw(Account account , Double amount){
        if (accountRepository.findById(account.getId()).isPresent()){
            if (amount <= account.getAmount()){
                account.setAmount(account.getAmount() - amount);
                return true;
            } else {
                throw new IllegalArgumentException("Withdrawal amount exceeds the current account balance");
            }
        }
        return false;
    }
    @Transactional
    public boolean deposit(Account account , Double amount){
        if (accountRepository.findById(account.getId()).isPresent()){
            account.setAmount(account.getAmount() + amount);
            return true;
        }
        return false;
    }

    public Account getAccount(Integer accountId) {
        Optional<Account> byId = accountRepository.findById(accountId);
        return byId.orElse(null);
    }
}
