package com.example.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "hiError")
    public String helloService(String name){
        return template.getForObject("http://service-hi/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi! "+name+",sorry,error";
    }
}
