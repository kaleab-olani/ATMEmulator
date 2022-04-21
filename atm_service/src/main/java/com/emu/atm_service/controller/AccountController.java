package com.emu.atm_service.controller;

import com.emu.atm_service.model.Account;
import com.emu.atm_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "withdraw/{account_id}")
    public Account accountWithDraw(@PathVariable("account_id") Integer accountId, @RequestBody Double amount){
        Account account = accountService.getAccount(accountId);
        if (account!=null){
            accountService.withdraw(account, amount);
            return account;
        } else {
            throw new IllegalStateException(String.format("Account with ID %d Does not exist.", accountId));
        }
    }
    @PostMapping(path = "deposit/{account_id}")
    public Account accountDeposit(@PathVariable("account_id") Integer accountId, @RequestBody Double  amount){
        Account account = accountService.getAccount(accountId);
        if (account!=null){
            accountService.deposit(account, amount);
            return account;
        } else {
            throw new IllegalStateException(String.format("Account with ID %d Does not exist.", accountId));
        }
    }
}
