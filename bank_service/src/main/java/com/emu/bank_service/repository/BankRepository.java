package com.emu.bank_service.repository;

import com.emu.bank_service.models.Bank;
import com.emu.bank_service.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
}
