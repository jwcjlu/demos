package com.jwcjlu.demos.proxy;

/**
 * Created by jwcjlu on 2019/8/30.
 */
public class DBQuery implements IDBQuery{
    @Override
    public String request() {
        return "request ...";
    }
}
