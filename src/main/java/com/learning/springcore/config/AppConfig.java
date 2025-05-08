package com.learning.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.learning.springcore.service","com.learning.springcore.repository","com.learning.springcore.beans"})
@PropertySource("classpath:app.properties")
public class AppConfig {
    public AppConfig() {
        System.out.println("[");
    }

}
