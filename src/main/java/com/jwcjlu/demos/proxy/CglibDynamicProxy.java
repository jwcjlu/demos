package com.jwcjlu.demos.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by jwcjlu on 2019/8/30.
 */
public class CglibDynamicProxy {
    public static IDBQuery createDynamicProxy(){
        Enhancer enhancer=new Enhancer();
        //设置方法拦截器
        enhancer.setCallback(new ProxyMethodInterceptor(new DBQuery()));
        //设置要实现的接口列表
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        //产生动态代理对象
        return (IDBQuery)enhancer.create();
    }
}
