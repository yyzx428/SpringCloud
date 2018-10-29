package com.example.feign.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFactory {
    @Bean
    @RefreshScope
    public Globals globals(){
        return new Globals();
    }
}
