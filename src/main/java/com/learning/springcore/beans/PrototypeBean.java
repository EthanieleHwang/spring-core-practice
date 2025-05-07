package com.learning.springcore.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    private static int instanceCount = 0;
    private int instanceId;

    public PrototypeBean(){
        instanceId = ++instanceCount;
        System.out.println("[Bean Lifecycle] PrototypeBean ("+instanceId+"): Constructor called - Creating a NEW instance!" );
    }

    @PostConstruct
    public void initPrototype() {
        System.out.println("00000[Bean Lifecycle] PrototypeBean ("+instanceId+"): @PostConstruct - Initializing resources...");
    }

    public void showMessage(){
        System.out.println("Message from PrototypeBean instance #"+instanceId+",HashCode:"+this.hashCode()  );
    }

    @PreDestroy
    public void destroyPrototype(){
        System.out.println("111111[Bean Lifecycle] PrototypeBean ("+instanceId+"): @PreDestroy: <<< THIS SHOULD NOT BE CALLED BY SPRING for prototype beans! >>>");
    }

}
