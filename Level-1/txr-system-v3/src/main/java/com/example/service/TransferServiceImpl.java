package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;

public class TransferServiceImpl implements TransferService{

    private static Logger logger=Logger.getLogger("txr-system");

    private AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        logger.debug("TransferService instance created..");
        this.accountRepository = accountRepository;
    }


    // thread-1
    @Override
    public void transfer(double amount, String sourceAccNumber, String targetAccNumber){

        logger.info("transfer initiated.."); // blocking-IO

        try {
            Account sourceAccount = accountRepository.loadAccount(sourceAccNumber);
            Account targetAccount = accountRepository.loadAccount(targetAccNumber);

            logger.info("debit & credit");
//        if(amount>sourceAccount.getBalance()){
//            logger.warn("no balance..");
//        }
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);

            accountRepository.updateAccount(sourceAccount);
            accountRepository.updateAccount(targetAccount);

            logger.info("transfer finished..");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

}
