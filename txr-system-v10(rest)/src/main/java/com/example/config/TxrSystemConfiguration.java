package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@Import(value = {JpaConfiguration.class})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = {"com.example"})
public class TxrSystemConfiguration {

}
