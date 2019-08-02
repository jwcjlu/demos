package com.jwcjlu.demos.mutilThread;

import java.util.concurrent.TimeUnit;

/**
 * Created by jwcjlu on 2019/7/26.
 */
public class MutilThread {


    public static void main(String[] args) throws InterruptedException {
        Object m1=new Object();
        Object m2=new Object();
        Object m3=new Object();
        Worker w1=new Worker(m2,m1,"A");
        Worker w2=new Worker(m3,m2,"B");
        Worker w3=new Worker(m1,m3,"C");
        Thread t1=new Thread(w1);
        Thread t2=new Thread(w2);
        Thread t3=new Thread(w3);
        t1.start();
        t2.start();
        t3.start();
        TimeUnit.SECONDS.sleep(1);
        synchronized (m1) {
            m1.notify();
        }


    }
}
class Worker implements Runnable{
    private Object preLock;
    private Object lock;
    String prefix;
    public Worker(Object preLock,Object lock,String prefix){
        this.prefix=prefix;
        this.preLock=preLock;
        this.lock=lock;
    }



    @Override
    public void run() {

            int i = 0;
            while (i < 100) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(prefix+"-"+i);
                synchronized (preLock) {
                    preLock.notify();
                }
                i++;


        }
    }
}