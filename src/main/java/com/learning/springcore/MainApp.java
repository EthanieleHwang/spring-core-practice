package com.learning.springcore;

import com.learning.springcore.config.AppConfig;
import com.learning.springcore.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
            System.out.println("greetingService: " + greetingService.getGreeting());
            context.close();
        }
    }
}
