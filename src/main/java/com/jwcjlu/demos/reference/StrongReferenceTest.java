package com.jwcjlu.demos.reference;

/**
 * Created by jwcjlu on 2019/9/4.
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        MyDate date = new MyDate();
        System.gc();
    }
}
