package com.jwcjlu.demos.bytebuddy;

import java.lang.reflect.Method;

public class LostTimeMethodAroundInterceptor implements  MethodAroundInterceptor {
    @Override
    public void beforeMethod(Object targetObject, Method method, Object[] allArguments, Class<?>[] parameterTypes, MethodInvokerResult result) {
        long currentTime=System.currentTimeMillis();
        ContextManager.set(currentTime);
        System.out.println("执行前的时间："+currentTime);
    }

    @Override
    public Object afterMethod(Object targetObject, Method method, Object[] allArguments, Class<?>[] parameterTypes, Object result) {
        long beforeTime= ContextManager.get();
        long currentTime=System.currentTimeMillis();
        System.out.println("执行后的时间："+currentTime);
        System.out.println("方法耗时"+(currentTime-beforeTime));
        return result;
    }

    @Override
    public void handleMethodException(Object targetObject, Method method, Object[] allArguments, Class<?>[] parameterTypes, Throwable t) {

    }
}
