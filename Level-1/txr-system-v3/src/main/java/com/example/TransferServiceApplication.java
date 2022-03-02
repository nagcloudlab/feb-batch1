package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;

public class TransferServiceApplication {
    public static void main(String[] args) {

        // init / boot
        AccountRepository jdbcAccountRepository=new JdbcAccountRepository();
        AccountRepository jpaAccountRepository=new JpaAccountRepository();
        TransferService transferService=new TransferServiceImpl(jdbcAccountRepository);

        System.out.println("-".repeat(50));

        // Use

        transferService.transfer(100.00,"1","2");
        System.out.println("-".repeat(25));
        transferService.transfer(200.00,"1","2");

        System.out.println("-".repeat(50));
        // destroy

        //.....


    }
}
