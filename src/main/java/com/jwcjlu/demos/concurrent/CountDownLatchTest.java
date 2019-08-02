package com.jwcjlu.demos.concurrent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by jwcjlu on 2019/5/24.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        CountDownLatch latch=new CountDownLatch(5);
        Runnable runnable=()->{try {
            TimeUnit.MILLISECONDS.sleep(100);
            latch.countDown();
           long count=latch.getCount();
            latch.await();
            System.out.println(Thread.currentThread()+":end"+count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }};
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        latch.await();
        System.out.println("end");
        System.out.println((1<<16-1)&21212);
        Map map=new HashMap();
        for (Object o : map.entrySet()) {
            
        }
    }
}
