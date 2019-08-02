package com.jwcjlu.demos.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jwcjlu on 2019/8/1.
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put(1, "bbb");
        map.put(2, "cccc");
        map.put(3, "bbb");
        map.put(4, "cccc");
        map.put(5, "bbb");
        map.put(6, "cccc");
        map.put(7, "bbb");
        map.put(8, "cccc");
        map.put(9, "bbb");
        map.put(10, "cccc");
        map.put(11, "bbb");
        map.put(12, "cccc");
        map.put(13, "bbb");
        map.put(14, "cccc");
        map.put(15, "bbb");
        map.put(16, "cccc");
        map.put(17, "bbb");
        map.put(18, "cccc");
        map.put(19, "bbb");
        System.out.println(3^5);
        System.out.println(4^5);
    }
}
