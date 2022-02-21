package com.example.repository;

import com.example.model.Account;

public class JdbcAccountRepository implements AccountRepository {

    public JdbcAccountRepository() {
        System.out.println("JdbcAccountRepository instance created..");
    }

    @Override
    public Account loadAccount(String number){
        System.out.println("loading account-"+number);
        //....
        return new Account(number,1000.00);
    }

    @Override
    public void updateAccount(Account account){
        System.out.println("updating account-"+account.getNumber());
        //...
        return;
    }

}
