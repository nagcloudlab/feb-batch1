package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Profile(value = {"dev","qa"})
public class GreetingController {
//
//    @Value("${greeting.message: hello}")
//    String message;
//
//    @Value("${greeting.messages}")
//    List<String> messages;
//
//    // SpEL
//    @Value("#{${greeting.locale-messages}}")
//    Map<String,String> localeMessages;

    @Autowired
    private GreetingProperties greetingProperties;

    @Autowired
    private Environment environment;

    @GetMapping("/api/greeting")
    public String doGreeting(){

        String[] profiles=environment.getActiveProfiles();
        System.out.println(Arrays.stream(profiles).collect(Collectors.joining(",")));

        String messages= environment.getProperty("greeting.messages");
        System.out.println(messages);

        int port=environment.getProperty("server.port",Integer.class);
        System.out.println(port);

        return greetingProperties.getMessage();
    }

}
