package com.example;

import com.example.config.TxrSystemConfiguration;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransferServiceApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(TxrSystemConfiguration.class);

        System.out.println("-".repeat(50));

        // Use
        TransferService transferService= (TransferService) applicationContext.getBean("transferService");
        System.out.println(transferService.getClass());
        transferService.transfer(5000.00,"2","1");

        System.out.println("-".repeat(50));
        // destroy
        applicationContext.close();
        //.....


    }
}
