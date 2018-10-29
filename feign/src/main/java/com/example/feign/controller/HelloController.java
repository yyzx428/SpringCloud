package com.example.feign.controller;

import com.example.feign.config.Globals;
import com.example.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @Autowired
    Globals globals;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return helloService.sayHello(name);
    }

    @RequestMapping(value = "/getEnvironment", method = RequestMethod.GET)
    public String getEnvironment(){
        return globals.getEnvironment();
    }
}

