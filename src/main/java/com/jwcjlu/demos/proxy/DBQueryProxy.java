package com.jwcjlu.demos.proxy;

/**
 * Created by jwcjlu on 2019/8/30.
 */
public class DBQueryProxy implements IDBQuery{
    private IDBQuery real=null;
    /* (non-Javadoc)
     * @see Pattern.DynamicProxy.IDBQuery#request()
     */
    @Override
    public String request() {
        if(real==null){
            real=new DBQuery();
        }

        //调用被代理的对象
       return real.request();
    }
}
