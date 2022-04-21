package com.emu.atm_service.service;


import com.emu.atm_service.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AccountService {

    public boolean withdraw(Account account , Double amount){

        return false;
    }
    public boolean deposit(Account account , Double amount){
        return false;
    }

    public Account getAccount(Integer accountId) {
        return null;
    }
}
