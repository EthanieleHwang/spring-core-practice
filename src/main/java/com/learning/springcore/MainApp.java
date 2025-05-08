package com.learning.springcore;

import com.learning.springcore.config.AppConfig;
import com.learning.springcore.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        System.out.println("\nStep 4: Using the retrieved bean with injected values...");
        String personalizedGreeting = greetingService.getGreeting("Explores");
        System.out.println(" Personalized Greeting: " + personalizedGreeting +"\"");
            context.close();
        }
}
