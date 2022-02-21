package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;

public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        System.out.println("TransferService instance created..");
        this.accountRepository = accountRepository;
    }


    @Override
    public void transfer(double amount, String sourceAccNumber, String targetAccNumber){

        System.out.println("transfer initiated..");

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
