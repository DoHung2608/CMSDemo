package com.example.miniproject.service;

import com.example.miniproject.model.database.Account;
import com.example.miniproject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public Account findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    public boolean saveAccount(Account account) {
        return accountRepository.saveAccount(account);
    }
}
