package com.example.service;

import com.example.model.Account;
import com.example.repository.JdbcAccountRepository;

public class TransferService {


    public TransferService() {
        System.out.println("TransferService instance created..");
    }

    public void transfer(double amount, String sourceAccNumber, String targetAccNumber){

        System.out.println("transfer initiated..");

        JdbcAccountRepository accountRepository=new JdbcAccountRepository();

        Account sourceAccount=accountRepository.loadAccount(sourceAccNumber);
        Account targetAccount=accountRepository.loadAccount(targetAccNumber);

        System.out.println("debit & credit");
        sourceAccount.setBalance(sourceAccount.getBalance()-amount);
        targetAccount.setBalance(targetAccount.getBalance()+amount);

        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(targetAccount);

        System.out.println("transfer finished..");

    }

}
