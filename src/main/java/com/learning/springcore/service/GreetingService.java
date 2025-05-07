package com.learning.springcore.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("greetingService")
public class GreetingService {
    public GreetingService(){
        System.out.println("[Bean Lifecycle] GreetingService: Constructor called - I'm being created by Spring!");
    }

    //初始化方法
    @PostConstruct
    public void initialize() {
        System.out.println("00000[Bean Lifecycle] GreetingService: @PostConstruct : Dependencies injected (if any),ready for initialization!");
        System.out.println("00000[Bean Lifecycle - GreetingService] Initializing resources...");
    }
    public String getGreeting() {
        return "Hello from Spring Bean！Welcome to the IoC Container!";

    }

    //销毁方法
    @PreDestroy
    public void cleanup(){
        System.out.println("11111[Bean Lifecycle - GreetingService] @PreDestroy: Container is shutting down. Cleaning up resources ...");
        // Perform any cleanup tasks here
    }
}
