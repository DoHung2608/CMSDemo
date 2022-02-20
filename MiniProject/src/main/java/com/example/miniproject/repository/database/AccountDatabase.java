package com.example.miniproject.repository.database;

import com.example.miniproject.model.database.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDatabase extends JpaRepository<Account,Integer> {
    @Query("select c from Account c where c.email = :email")
    public List<Account> findAccountByEmail(String email);
}
