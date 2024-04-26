package com.kh.server.async;

import lombok.Data;

@Data
public class AsyncUserA {

    private String name;
    private String age;

    public AsyncUserA(String name, String age){
        this.name = name;
        this.age = age;
    }
}
