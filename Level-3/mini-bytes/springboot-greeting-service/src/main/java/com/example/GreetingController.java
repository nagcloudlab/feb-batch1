package com.example;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

//    private int greetingCount=0;

    private RedisTemplate redisTemplate;

    public GreetingController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @GetMapping("/api/greeting")
    public String doGreeting(){
        ValueOperations<String,Integer> valueOperations= redisTemplate.opsForValue();
        Integer count=valueOperations.get("count");
        if(count==null){
            count=1;
        }else{
            count+=1;
        }
        valueOperations.set("count",count);
        return "hello from springboot-greeting-service - "+count;
    }

}
