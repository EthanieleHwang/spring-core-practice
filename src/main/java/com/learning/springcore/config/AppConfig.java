package com.learning.springcore.config;

import com.learning.springcore.legacy.LegacyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.learning.springcore.service","com.learning.springcore.repository","com.learning.springcore.beans"})
@PropertySource("classpath:app.properties")
public class AppConfig {
    @Value("${legacy.service.config:DefaultLegacyConfig}")
    private String legacyConfigValue;

    @Bean
    public LegacyService legacyServiceBean() {
        System.out.println("[AppConfig] Creating legacyService bean via @Bean method with config: " + legacyConfigValue);
        return new LegacyService(legacyConfigValue); //手动创建并传入配置
    }

    

}
