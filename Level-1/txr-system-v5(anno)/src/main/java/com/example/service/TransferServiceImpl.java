package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("transferService")
public class TransferServiceImpl implements TransferService{


    private AccountRepository accountRepository;

    @Autowired
    public TransferServiceImpl(AccountRepository accountRepository) {
        log.debug("TransferService instance created..");
        this.accountRepository = accountRepository;
    }

    public void init(){
        log.info("init()");
    }
    public void destroy(){
        log.info("destroy()");
    }


    // thread-1
    @Override
    public void transfer(double amount, String sourceAccNumber, String targetAccNumber){

        log.info("transfer initiated.."); // blocking-IO

        try {
            Account sourceAccount = accountRepository.loadAccount(sourceAccNumber);
            Account targetAccount = accountRepository.loadAccount(targetAccNumber);

            log.info("debit & credit");
//        if(amount>sourceAccount.getBalance()){
//            logger.warn("no balance..");
//        }
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);

            accountRepository.updateAccount(sourceAccount);
            accountRepository.updateAccount(targetAccount);

            log.info("transfer finished..");
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }

}
