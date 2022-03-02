package com.example;

import com.cognizant.CognizantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableAutoConfiguration(
//        exclude = {PersistenceExceptionTranslationAutoConfiguration.class}
)
@ComponentScan
public class TransferServiceApplication {
    public static void main(String[] args) {

        // init/boot
        ConfigurableApplicationContext applicationContext=
                SpringApplication.run(TransferServiceApplication.class,args);


        CognizantService cognizantService=applicationContext.getBean(CognizantService.class);
        String tngInfo=cognizantService.getTraining();
        System.out.println(tngInfo);

    }
}
