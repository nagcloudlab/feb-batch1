package com.example.service;

import com.example.entity.Account;
import com.example.exception.AccountBalanceException;
import com.example.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("transferService")
public class TransferServiceImpl implements TransferService {

    private final AccountRepository accountRepository;

    public TransferServiceImpl(@Qualifier("jpa") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void init() {
        log.info("init()");
    }

    public void destroy() {
        log.info("destroy()");
    }


    // thread-1
    @Transactional(
//            transactionManager = "transactionManager",
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            rollbackFor = {},
            noRollbackFor = {},
            timeout = 45
    )
    @Override
    public void transfer(double amount, String sourceAccNumber, String targetAccNumber) {

//        log.info("transfer initiated.."); // blocking-IO

        try {
            Account sourceAccount = accountRepository.loadAccount(sourceAccNumber);
            Account targetAccount = accountRepository.loadAccount(targetAccNumber);

            if(sourceAccount.getBalance()<amount)
                throw new AccountBalanceException("no enough balance");

            log.info("debit & credit");
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);

            accountRepository.updateAccount(sourceAccount);

            if (1 != 1)
                throw new RuntimeException("oops");

            accountRepository.updateAccount(targetAccount);

            log.info("transfer finished..");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

    }

}
