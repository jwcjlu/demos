package com.jwcjlu.demos.reference;

import java.lang.ref.WeakReference;

/**
 * Created by jwcjlu on 2019/9/4.
 * 结果说明：在JVM垃圾回收运行时，弱引用被终止.
 *
 * WeakReference ref = new WeakReference(new MyDate());
 * System.gc();
 *
 * 等同于：
 *
 * MyDate date = new MyDate();
 *
 * // 垃圾回收
 * If(JVM.内存不足()) {
 * date = null;
 * System.gc();
 * }
 *
 *
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference ref = new WeakReference(new MyDate());
        System.gc();
    }
}
