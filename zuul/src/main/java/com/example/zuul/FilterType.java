package com.example.zuul;

public enum FilterType {
    Pre("pre"),Routing("routing"),Afer("post"),Error("error");

    FilterType(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    private String value;

}
