package com.jwcjlu.demos;

import com.jwcjlu.demos.javaagent.annotation.Apm;

public class HelloWorld {
    @Apm
    public void hello(){
        System.out.println("hello world");
    }
}
