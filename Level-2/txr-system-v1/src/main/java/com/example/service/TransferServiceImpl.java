package com.example.service;

import com.example.entity.Account;
import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(
            rollbackFor = {RuntimeException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            timeout = 45
    )
    @Override
    public boolean transfer(double amount, String sourceAccNum, String targetAccNum) {

        log.info("transfer initiated..");

        Account sourceAccount = accountRepository.findById(sourceAccNum)
                .orElseThrow(() -> new AccountNotFoundException("account not found - " + sourceAccNum));
        Account targetAccount = accountRepository.findById(targetAccNum)
                .orElseThrow(() -> new AccountNotFoundException("account not found - " + targetAccNum));
        if (sourceAccount.getBalance() < amount)
            throw new AccountBalanceException("balance - " + sourceAccount.getBalance());

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        return true;
    }

}
