package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class GreetingController {

    @GetMapping("/api/greeting")
    public String doGreeting() throws InterruptedException {
        System.out.println(Thread.currentThread());
        // IO
        // IO ==> read/write on any IO-cource ( file, database, n/w services )
        TimeUnit.SECONDS.sleep(2);
        return "hello";
    }

}
