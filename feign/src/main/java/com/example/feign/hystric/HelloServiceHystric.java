package com.example.feign.hystric;

import com.example.feign.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystric implements HelloService{
    @Override
    public String sayHello(String name) {
        return "sorry!"+name;
    }
}
