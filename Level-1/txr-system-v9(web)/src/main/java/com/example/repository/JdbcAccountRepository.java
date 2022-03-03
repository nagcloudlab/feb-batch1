package com.example.repository;

import com.example.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Slf4j
@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository{

    private DataSource dataSource;

    @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource=dataSource;
        log.debug("JdbcAccountRepository instance created.");
    }

    @Override
    public Account loadAccount(String number) {
        log.info("Loading account-"+number);
        return new Account(number,1000.00);
    }

    @Override
    public void updateAccount(Account account) {
        log.info("updating account-"+account.getNumber());
    }
}