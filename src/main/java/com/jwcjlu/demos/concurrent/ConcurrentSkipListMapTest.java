package com.jwcjlu.demos.concurrent;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by jwcjlu on 2019/5/25.
 */
public class ConcurrentSkipListMapTest {

    public static void main(String[] args) {
        ConcurrentSkipListMap skipListMap=new ConcurrentSkipListMap();
        skipListMap.put("aaaa","bbbbb");
        skipListMap.put("cccc","ddddd");
        skipListMap.put("eeee","fffff");
        System.out.println(Integer.MIN_VALUE);
        System.out.println(0x80000001&8);
    }
}
