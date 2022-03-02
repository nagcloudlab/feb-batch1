package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

public class JdbcAccountRepository implements AccountRepository{

    private static Logger logger=Logger.getLogger("txr-system");

    public JdbcAccountRepository() {
        logger.debug("JdbcAccountRepository instance created.");
    }

    @Override
    public Account loadAccount(String number) {
        logger.info("Loading account-"+number);
        return new Account(number,1000.00);
    }

    @Override
    public void updateAccount(Account account) {
        logger.info("updating account-"+account.getNumber());
    }
}
