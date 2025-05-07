package com.learning.springcore.service;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {
    public GreetingService(){
        System.out.println("[Bean Lifecycle] GreetingService: Constructor called - I'm being created by Spring!");
    }

    public String getGreeting() {
        return "Hello from Spring Bean！Welcome to the IoC Container!";
    }
}
