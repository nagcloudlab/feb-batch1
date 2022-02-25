package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service("transferService")
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;

    public TransferServiceImpl(@Qualifier("jdbc") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void init() {
        log.info("init()");
    }

    public void destroy() {
        log.info("destroy()");
    }


    // thread-1
    @Override
    public void transfer(double amount, String sourceAccNumber, String targetAccNumber) {

//        log.info("transfer initiated.."); // blocking-IO

        try {
            Account sourceAccount = accountRepository.loadAccount(sourceAccNumber);
            Account targetAccount = accountRepository.loadAccount(targetAccNumber);

            log.info("debit & credit");
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);

            if (1 != 1)
                throw new RuntimeException("oops");

            accountRepository.updateAccount(sourceAccount);
            accountRepository.updateAccount(targetAccount);

            log.info("transfer finished..");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

    }

}
