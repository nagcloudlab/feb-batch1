package com.example.repository;

import com.example.model.Account;

public class JpaAccountRepository implements AccountRepository{
    
    @Override
    public Account loadAccount(String number) {
        return new Account(number,1000.00);
    }

    @Override
    public void updateAccount(Account account) {

    }
}
