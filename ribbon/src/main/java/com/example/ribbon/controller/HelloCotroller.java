package com.example.ribbon.controller;

import com.example.ribbon.entity.Student;
import com.example.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloCotroller {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    @ResponseBody
    public String hi(@RequestParam String name){
        return helloService.helloService(name);
    }
}

