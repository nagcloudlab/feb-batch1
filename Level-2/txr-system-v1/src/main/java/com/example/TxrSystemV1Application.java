package com.example;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.service.TransferService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TxrSystemV1Application {

    public static void main(String[] args) {
        SpringApplication.run(TxrSystemV1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TransferService transferService){
        return args->{

//         transferService.transfer(100.00,"1","2");

        };
    }


}
