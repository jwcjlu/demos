package com.jwcjlu.demos.proxy;

import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by jwcjlu on 2019/8/30.
 */
public class Testing {
    public static void main(String[] args) throws Throwable {
        Tuning(1);
        Tuning(2);
        Tuning(3);
        Tuning(4);
        Tuning(5);
    }
    private static void Tuning(int type) throws Throwable{
        IDBQuery proxy=null;
        long start=System.currentTimeMillis();
        String typeName="";

        switch(type){
            case 1:
                proxy=new DBQueryProxy();
                typeName="Proxy";
                break;
            case 2:
                proxy=JDKDynamicProxy.createDynamicProxy();
                typeName="JDKProxy";
                break;
            case 3:
                proxy=CglibDynamicProxy.createDynamicProxy();
                typeName="CglibProxy";
                break;
            case 4:
                proxy=createJavassistProxy();
                typeName="JavassistProxy";
                break;
            case 5:
                proxy=createJavassistBytecodeProxy();
                typeName="JavassistProxy";
                break;
        }
        long end=System.currentTimeMillis();
        System.out.println(typeName+" created: "+(end-start));
        System.out.println(proxy.getClass().getName());

        start=end;
        //执行3千万次，看看执行的时间是多少
        for(int i=0;i<30000000;i++)
            proxy.request();

        end=System.currentTimeMillis();
        System.out.println("Call "+typeName+" request(): "+(end-start));
        System.out.println("");
    }
    private static IDBQuery createJavassistBytecodeProxy() throws Throwable{
        ClassPool pool= ClassPool.getDefault();
        //创建一个类
        CtClass ctclass=pool.makeClass(IDBQuery.class.getName()+"_javassistbytecode_proxy");
        //添加要实现的接口
        ctclass.addInterface(pool.get(IDBQuery.class.getName()));

        ctclass.addConstructor(CtNewConstructor.defaultConstructor(ctclass));
        //添加域
        ctclass.addField(CtField.make("public "+IDBQuery.class.getName()+" real;", ctclass));
        //添加方法
        ctclass.addMethod(CtNewMethod.make("public void request(){ if (real==null){ real=new "
                +DBQuery.class.getName()+"();} return real.request();}", ctclass));

        Class pc=ctclass.toClass();
        return (IDBQuery)pc.newInstance();
    }
    private static IDBQuery createJavassistProxy() {
        ProxyFactory factory=new ProxyFactory();
        factory.setInterfaces(new Class[]{IDBQuery.class});
        IDBQuery proxy=null;

        class ProxyMethodHandler implements MethodHandler {
            private IDBQuery proxied=null;

            public ProxyMethodHandler(IDBQuery proxied){
                this.proxied=proxied;
            }
            @Override
            public Object invoke(Object arg0, Method method, Method arg2,
                                 Object[] arg3) throws Throwable {
                //System.out.println("Javassist Method Handler invoke.");
                return method.invoke(proxied, arg3);
            }
        }

        factory.setHandler(new ProxyMethodHandler(new DBQuery()));
        try{
            proxy=(IDBQuery)factory.create(null, null);
        }catch(Exception e){
            e.printStackTrace();
        }

        return proxy;
    }
}
