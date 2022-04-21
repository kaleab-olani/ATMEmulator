package com.emu.bank_service.repository;

import com.emu.bank_service.models.Account;
import com.emu.bank_service.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
