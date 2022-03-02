package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransferServiceApplication {
    public static void main(String[] args) {

        // init / boot

         /*
            Loading bean-definitions
            BFPP
                bean creation
                dependency injection
                BPP - before-init
                bean init
                BPP - after-init
         */
        ConfigurableApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("txr-system.xml");



        System.out.println("-".repeat(50));

        // Use
        TransferService transferService= (TransferService) applicationContext.getBean("transferService");
        transferService.transfer(100.00,"1","2");

        System.out.println("-".repeat(50));
        // destroy
        applicationContext.close();
        //.....


    }
}
