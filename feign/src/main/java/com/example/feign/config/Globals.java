package com.example.feign.config;

import org.springframework.beans.factory.annotation.Value;

public class Globals {
    @Value("${pro}")
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
