package com.learning.springcore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("greetingService")
public class GreetingService {

    @Value("${greeting.prefix}")
    private String prefix;

    @Value("${application.name}")
    private String appNameFromProperties;

    @Value("Hardcoded Suffix")
    private String literalSuffix;

    @Value("${greeting.suffix:Default Suffix}")
    private String suffixWithDefault;

    @Value("${max.threads}")
    private int maxThreads;

    @Value("${feature.toggle.newUI}")
    private boolean newUiEnabled;

    public GreetingService() {
        System.out.println("[Bean Lifecycle - GreetingService] Constructor.");
        //在构造函数中，@Value注入的属性值尚未被注入
        System.out.println("[Constructor] prefix: " + prefix);
    }

    @PostConstruct
    public void initialize() {
        System.out.println("[Bean Lifecycle - GreetingService] @PostConstruct: Values should be injected now.");
        System.out.println("[PostConstruct] prefix: " + prefix);
        System.out.println("[PostConstruct] appNameFromProperties: " + appNameFromProperties);
        System.out.println("[PostConstruct] literalSuffix: " + literalSuffix);
        System.out.println("[PostConstruct] suffixWithDefault: " + suffixWithDefault);
        System.out.println("[PostConstruct] maxThreads: " + maxThreads);
        System.out.println("[PostConstruct] newUiEnabled: " + newUiEnabled);
    }

    public String getGreeting(String name) {
        System.out.println(" [Bean Usage - GreetingService] getGreeting(String) called.");
        return prefix+" "+name+suffixWithDefault+" "+literalSuffix+" (from " + appNameFromProperties +")";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[Bean Lifecycle - GreetingService] @PreDestroy: Cleaning up resources...");
    }


}
