package com.cognizant;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnJava(JavaVersion.SEVENTEEN)
//@ConditionalOnMissingClass(value = {"com.cognizant.CognizantService"})
//@ComponentScan(basePackages = {"com.cognizant"})
public class CongizantAutoConfiguration {


    @Bean
    public CognizantService cognizantService(){
        return new CognizantServiceImpl();
    }


}
