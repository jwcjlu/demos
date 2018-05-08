package com.jwcjlu.demos.bytebuddy;

import java.lang.reflect.Method;

public class WaiterMethodAroundInterceptor implements  MethodAroundInterceptor {
    public void beforeMethod(Object targetObject, Method method, Object[] allArguments, Class<?>[] parameterTypes, MethodInvokerResult result) {
        System.out.println("welcome。。。。。。。");
    }

    public Object afterMethod(Object targetObject, Method method, Object[] allArguments, Class<?>[] parameterTypes, Object result) {
        System.out.println("ths  bye bye！！！");
        return result;
    }

    public void handleMethodException(Object targetObject, Method method, Object[] allArguments, Class<?>[] parameterTypes, Throwable t) {
        System.out.println("dinner error");
    }
}
