package com.jwcjlu.demos.proxy;



import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by jwcjlu on 2019/8/30.
 */
public class ProxyMethodInterceptor implements MethodInterceptor {
    private IDBQuery proxied=null;

    public ProxyMethodInterceptor(IDBQuery proxied){
        this.proxied=proxied;
    }

    @Override
    public Object intercept(Object arg0, Method method, Object[] arg2,
                            MethodProxy arg3) throws Throwable {
        //方法拦截
        return method.invoke(proxied, arg2);
    }
}
