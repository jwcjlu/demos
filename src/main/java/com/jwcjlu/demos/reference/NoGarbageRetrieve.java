package com.jwcjlu.demos.reference;

/**
 * Created by jwcjlu on 2019/9/4.
 */
public class NoGarbageRetrieve {
    public static void main(String[] args) {
        MyDate date = new MyDate();
        date = null;
    }
}
