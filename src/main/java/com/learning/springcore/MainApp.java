package com.learning.springcore;

import com.learning.springcore.beans.PrototypeBean;
import com.learning.springcore.config.AppConfig;
import com.learning.springcore.service.GreetingService;
import com.learning.springcore.service.MessageService;
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
//
//        //2.按bean名称获取
//        Object beanByNameObject = context.getBean("greetingService");
//        GreetingService greetingServiceByName = null;
//        if(beanByNameObject instanceof GreetingService){
//            greetingServiceByName = (GreetingService) beanByNameObject;
//            System.out.println("Bean retrieved by name ('greetingService'):"+greetingServiceByName);
//        }else{
//            System.out.println("Failed to cast bean retrieved by name to GreetingService");
//        }
//
//        //3.按照类型和名称获取
//        GreetingService greetingServiceByNameAndType = context.getBean("greetingService", GreetingService.class);
//
//        System.out.println("Bean retrieved by name and type ('greetingService'):"+greetingServiceByNameAndType);
//
//        //验证获取到的单例Bean是否同一个实例。
//        System.out.println("\nStep 3: Verifying if retrieved beans are the same instance (singleton scope)...");
//
//        boolean isSameInstance12 = (greetingServiceByType == greetingServiceByName);
//        boolean isSameInstance13 = (greetingServiceByType == greetingServiceByNameAndType);
//
//        System.out.println("greetingServiceByType and greetingServiceByName are the same instance: " + isSameInstance12);
//        System.out.println("greetingServiceByType and greetingServiceByNameAndType are the same instance: " + isSameInstance13);
//
//        System.out.println("\nStep 4: Using the retrieved bean ...");
//        String message = greetingServiceByType.getGreeting();
//        System.out.println("Message from GreetingSerive:\""+message+"\"");
//
//        System.out.println("\nStep 5: Closing the Spring ApplicationContext ...");
//        ((AnnotationConfigApplicationContext) context).close();
//        System.out.println("Container closed successfully!");
//        System.out.println("\n--- End of Spring IoC Container Demo ---");
//        System.out.println("1. Creating Spring IoC Container...");
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        System.out.println("   Container created.");
//
//        System.out.println("\n2. Getting the MessageService bean...");
//        // 获取接口类型的 Bean，Spring 会找到它的实现类 MessageServiceImpl
//        MessageService messageService = context.getBean(MessageService.class);
//        System.out.println("   Got bean instance: " + messageService);
//
//        System.out.println("\n3. Calling the bean's method...");
//        messageService.printMessage(); // 调用方法，触发内部依赖的使用

        // 验证获取的是同一个 Repository 实例 (因为 Repository 默认也是 Singleton)
        // (需要先修改 MessageServiceImpl，添加 getter 方法暴露 repoField 和 repoSetter)
        // MessageRepository repo1 = messageService.getRepoField();
        // MessageRepository repo2 = messageService.getRepoSetter();
        // System.out.println("\nAre repoField and repoSetter the same instance? " + (repo1 == repo2)); // 预期 true
//
//        System.out.println("\n4. Closing the container...");
//        ((AnnotationConfigApplicationContext) context).close();
//        System.out.println("   Container closed.");

        System.out.println("\n--- Testing Prototype Scope ---");
        System.out.println("Requesting PrototypeBean instance A...");
        PrototypeBean protoA = context.getBean(PrototypeBean.class);
        protoA.showMessage();

        System.out.println("\nRequesting PrototypeBean instance B...");
        PrototypeBean protoB = context.getBean(PrototypeBean.class);
        protoB.showMessage();

        System.out.println("\nAre protoA and protoB the same instance? " + (protoA == protoB)); // 预期 false

        //即使再次获取同一个原型Bean实例，Spring也会创建一个新的实例。
        System.out.println("\nRequesting PrototypeBean instance C by name...");
        PrototypeBean protoC =(PrototypeBean) context.getBean("prototypeBean");
        protoC.showMessage();
        System.out.println("\nAre protoA and protoC the same instance? " + (protoA == protoC)); // 预期 false
        System.out.println("\nAre protoB and protoC the same instance? " + (protoB == protoC)); // 预期 false

        System.out.println("---------------------------------");
    }
}
