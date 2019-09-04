package com.jwcjlu.demos.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jwcjlu on 2019/8/30.
 */
public class JDKDynamicProxyHandler implements InvocationHandler {
    private IDBQuery proxied=null;

    /**
     * 创建动态代理处理对象
     * @param proxied
     */
    public JDKDynamicProxyHandler(IDBQuery proxied){
        this.proxied=proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        //调用被代理的对象的方法
        return method.invoke(proxied, args);
    }
}
