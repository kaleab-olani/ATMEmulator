package com.emu.bank_service.controller;

import com.emu.bank_service.models.Account;
import com.emu.bank_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A rest controller class for account related api gateways.
 * */
@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    private AccountService accountService;

    /**
     * A constructor with the account service dependency injected.
     * @param accountService An account service that will be auto wired (injected) when the constructor is called
     *
     * */
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * An account withdraw method to deduct amount from the customers account
     * @param accountId the id of the account to be deducted from. It is passed as part of the URL path
     * @param amount the amount of money to be deducted from the account. It is passed as
     * */
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
    /**
     *  An account withdraw method to deduct amount from the customers account
     *  @param accountId the id of the account to be credited. It is passed as part of the URL path
     *  @param amount the amount of money to be deposited from the account.
     * */
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
