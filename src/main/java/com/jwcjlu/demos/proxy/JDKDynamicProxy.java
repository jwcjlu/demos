package com.jwcjlu.demos.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by jwcjlu on 2019/8/30.
 */
public class JDKDynamicProxy {
    public static IDBQuery createDynamicProxy(){
        IDBQuery proxy=(IDBQuery) Proxy.newProxyInstance(IDBQuery.class.getClassLoader(),
                new Class[]{IDBQuery.class},
                new JDKDynamicProxyHandler(new DBQuery()));

        return proxy;
    }
}
