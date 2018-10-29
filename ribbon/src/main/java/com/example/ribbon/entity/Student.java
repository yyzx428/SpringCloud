package com.example.ribbon.entity;

import java.io.Serializable;

public class Student implements Serializable{
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", port=" + port +
                '}';
    }
}
