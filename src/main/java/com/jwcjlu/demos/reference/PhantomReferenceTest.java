package com.jwcjlu.demos.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by jwcjlu on 2019/9/4.
 * ReferenceQueue queue = new ReferenceQueue();
 * PhantomReference ref = new PhantomReference(new MyDate(), queue);
 * System.gc();
 *
 * 等同于：
 *
 * MyDate date = new MyDate();
 * date = null;
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(new MyDate(), queue);
        System.gc();
    }
}
