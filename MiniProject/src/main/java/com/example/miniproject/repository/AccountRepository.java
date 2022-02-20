package com.example.miniproject.repository;

import com.example.miniproject.model.database.Account;
import com.example.miniproject.model.database.Employee;
import com.example.miniproject.repository.database.AccountDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountRepository {
    @Autowired
    AccountDatabase accountDatabase;

    public Account findAccountByEmail(String email) {
        List<Account> list =  accountDatabase.findAccountByEmail(email);
        if( list == null || list.isEmpty()) return null;
        return list.get(0);
    }
    public boolean saveAccount(Account account) {
        Account saveAccount = accountDatabase.save(account);
        if (saveAccount != null) {
            return true;
        }
        return false;
    }
}
