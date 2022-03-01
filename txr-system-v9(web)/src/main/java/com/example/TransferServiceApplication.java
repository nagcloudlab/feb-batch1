package com.example;

import com.example.config.TxrSystemConfiguration;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class TransferServiceApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(TxrSystemConfiguration.class);

        System.out.println("-".repeat(50));

        // Use
        try {
            TransferService transferService = (TransferService) applicationContext.getBean("transferService");
            System.out.println(transferService.getClass());
            transferService.transfer(5000.00, "2", "1");
        }catch (Exception e){
            log.error(e.getMessage());
        }

        System.out.println("-".repeat(50));
        // destroy
        applicationContext.close();
        //.....


    }
}
