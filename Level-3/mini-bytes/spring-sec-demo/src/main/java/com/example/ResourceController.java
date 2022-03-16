package com.example;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/public-resource")
    public String getPublicResource(){
        return "PUBLIC-RESOURCE";
    }

    @GetMapping("/private-resource")
    public String getPrivateResource(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getAuthorities());
        return "PRIVATE-RESOURCE";
    }

}
