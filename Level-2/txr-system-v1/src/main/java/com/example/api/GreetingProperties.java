package com.example.api;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "greeting")
public class GreetingProperties {

    String message;
    List<String> messages;
//    Map<String,String> localeMessages;

}
