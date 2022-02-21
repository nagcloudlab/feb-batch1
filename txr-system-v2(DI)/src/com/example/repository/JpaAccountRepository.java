package com.example.repository;

import com.example.model.Account;

public class JpaAccountRepository implements AccountRepository{

    public JpaAccountRepository() {
        System.out.println("JpaAccountRepository instance created..");
    }

    public Account loadAccount(String number){
        System.out.println("loading account-"+number);
        //....
        return new Account(number,1000.00);
    }

    public void updateAccount(Account account){
        System.out.println("updating account-"+account.getNumber());
        //...
        return;
    }

}
