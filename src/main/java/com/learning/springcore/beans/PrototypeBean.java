package com.learning.springcore.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
    private static int instanceCount = 0;
    private int instanceId;

    public PrototypeBean(){
        instanceId = ++instanceCount;
        System.out.println("[Bean Lifecycle] PrototypeBean ("+instanceId+"): Constructor called - Creating a NEW instance!" );
    }

    public void showMessage(){
        System.out.println("Message from PrototypeBean instance #"+instanceId+",HashCode:"+this.hashCode()  );
    }

}
