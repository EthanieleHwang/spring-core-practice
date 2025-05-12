package com.learning.springcore;

import com.learning.springcore.config.AppConfig;
import com.learning.springcore.legacy.LegacyService;
import com.learning.springcore.service.GreetingService;
import com.learning.springcore.service.MessageService;
import com.learning.springcore.service.MessageServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//            GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
//        System.out.println("\nStep 4: Using the retrieved bean with injected values...");
//        String personalizedGreeting = greetingService.getGreeting("Explores");
//        System.out.println(" Personalized Greeting: " + personalizedGreeting +"\"");
//        System.out.println("\n --- Testing @Bean defined Bean ---");
//        LegacyService legacyService = context.getBean("legacyServiceBean", LegacyService.class);
//        legacyService.doWork();
//        System.out.println("\n ---------------");
//        MessageService messageService = (MessageService) context.getBean("greetingService",GreetingService.class);
        MessageService messageService = context.getBean(MessageService.class);
        messageService.printMessage();
        context.close();
        }
}
