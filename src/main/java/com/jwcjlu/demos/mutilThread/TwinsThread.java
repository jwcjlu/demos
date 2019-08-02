package com.jwcjlu.demos.mutilThread;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 双线程互斥锁
 * Created by jwcjlu on 2019/8/2.
 */
public class TwinsThread {
    private Sync sync = new Sync(2);

    class Sync extends AbstractQueuedSynchronizer {
        public Sync(int state) {
            setState(state);
        }

        @Override
        public int tryAcquireShared(int arg) {
            for (; ; ) {
                int state = getState();
                if (state < 1) {
                    return -1;
                }
                if (compareAndSetState(state, state - 1))
                    return 1;
            }


        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int state = getState();
                if (compareAndSetState(state, state + 1))
                    return true;
            }
        }
    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void unLock() {
        sync.releaseShared(1);
    }

    public static void main(String[] args) throws IOException {
        TwinsThread twinsThread=new TwinsThread();
        new Thread(()->{
            for(;;) {
                twinsThread.lock();
                try {
                    System.out.println("aaaaa");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    twinsThread.unLock();
                }
            }
        }).start();
        new Thread(()->{
            for(;;) {
                twinsThread.lock();
                try {
                    System.out.println("bbbbb");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    twinsThread.unLock();
                }
            }
        }).start();
        new Thread(()->{
            for(;;) {
                twinsThread.lock();
                try {
                    System.out.println("ccccc");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    twinsThread.unLock();
                }
            }
        }).start();
        System.in.read();
    }
}
