package com.jwcjlu.demos.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class Main {
    public static void main(String[]agrs)throws IllegalAccessException, InstantiationException, NoSuchMethodException{
        Class dynamicType =  new ByteBuddy().subclass(LanzhouService.class).method(ElementMatchers.named("service"))
                .intercept(MethodDelegation.to(new InstMethodInter(new WaiterMethodAroundInterceptor())))
                .make()
                .load(Main.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();
        Object s=dynamicType.newInstance();
        ((LanzhouService)s).service("zhangsan");

    }
}
