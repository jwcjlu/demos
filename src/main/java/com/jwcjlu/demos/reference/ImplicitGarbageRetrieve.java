package com.jwcjlu.demos.reference;

/**
 * Created by jwcjlu on 2019/9/4.
 */
public class ImplicitGarbageRetrieve {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyDate date = new MyDate();
        date = null;
        ReferenceTest.drainMemory();
    }
}
