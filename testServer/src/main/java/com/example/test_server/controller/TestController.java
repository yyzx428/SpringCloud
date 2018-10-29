package com.example.test_server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class TestController {
    @Value("${server.port}")
    int port;
    @RequestMapping("/hi")
    public Student home(@RequestParam String name) {
        return new Student().setPort(port).setName(name);
    }

    class Student implements Serializable{
        public String getName() {
            return name;
        }

        public Student setName(String name) {
            this.name = name;
            return this;
        }

        public int getPort() {
            return port;
        }

        public Student setPort(int port) {
            this.port = port;
            return this;
        }

        private String name;
        private int port;
    }
}
