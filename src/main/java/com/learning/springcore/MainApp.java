package com.learning.springcore;

import com.learning.springcore.config.AppConfig;
import com.learning.springcore.service.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("--- Spring IoC Container Demo ---");

        System.out.println("\nStep 1: Create Spring ApplicationContext (IoC Container) ...");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("IoC Container created successfully!");

        System.out.println("\nStep 2: Retrieve the GreetingService  bean from the IoC Container ...");

        GreetingService greetingServiceByType = context.getBean(GreetingService.class);
        System.out.println("Bean retrieved by type:"+greetingServiceByType);

        //2.按bean名称获取
        Object beanByNameObject = context.getBean("greetingService");
        GreetingService greetingServiceByName = null;
        if(beanByNameObject instanceof GreetingService){
            greetingServiceByName = (GreetingService) beanByNameObject;
            System.out.println("Bean retrieved by name ('greetingService'):"+greetingServiceByName);
        }else{
            System.out.println("Failed to cast bean retrieved by name to GreetingService");
        }

        //3.按照类型和名称获取
        GreetingService greetingServiceByNameAndType = context.getBean("greetingService", GreetingService.class);

        System.out.println("Bean retrieved by name and type ('greetingService'):"+greetingServiceByNameAndType);

        //验证获取到的单例Bean是否同一个实例。
        System.out.println("\nStep 3: Verifying if retrieved beans are the same instance (singleton scope)...");

        boolean isSameInstance12 = (greetingServiceByType == greetingServiceByName);
        boolean isSameInstance13 = (greetingServiceByType == greetingServiceByNameAndType);

        System.out.println("greetingServiceByType and greetingServiceByName are the same instance: " + isSameInstance12);
        System.out.println("greetingServiceByType and greetingServiceByNameAndType are the same instance: " + isSameInstance13);

        System.out.println("\nStep 4: Using the retrieved bean ...");
        String message = greetingServiceByType.getGreeting();
        System.out.println("Message from GreetingSerive:\""+message+"\"");

        System.out.println("\nStep 5: Closing the Spring ApplicationContext ...");
        ((AnnotationConfigApplicationContext) context).close();
        System.out.println("Container closed successfully!");
        System.out.println("\n--- End of Spring IoC Container Demo ---");


    }
}
