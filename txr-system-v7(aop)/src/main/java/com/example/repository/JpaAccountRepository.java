package com.example.repository;

import com.example.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Slf4j
@Repository("jpaAccountRepository")
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository{

    private DataSource dataSource;

    public JpaAccountRepository(DataSource dataSource) {
        this.dataSource=dataSource;
        log.debug("JpaAccountRepository instance created.");
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
