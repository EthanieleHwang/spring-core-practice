package com.learning.springcore.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.learning.springcore.service")
public class AppConfig {
    public AppConfig() {
        System.out.println("[Config] AppConfig: Constructor called - Spring is processing me!");
    }

}
