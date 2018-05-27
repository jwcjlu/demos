package com.jwcjlu.demos.javaagent;

public class EnchanceDefine {
    private String enhanceClass;
    private String method;
    public EnchanceDefine(String enhanceClass,String method){
        this.enhanceClass=enhanceClass;
        this.method=method;
    }
    public String getenhanceClass(){
        return enhanceClass;
    }
    public String getMethod(){
        return method;
    }

}
