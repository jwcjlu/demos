package com.jwcjlu.demos.reference;

import java.lang.ref.SoftReference;

/**
 * Created by jwcjlu on 2019/9/4.
 * 运行结果：
 *
 * <无任何输出>
 *
 * 结果说明：在内存不足时，软引用被终止。软引用被禁止时，
 *
 * SoftReference ref = new SoftReference(new MyDate());
 * ReferenceTest.drainMemory();
 *
 * 等价于
 *
 * MyDate date = new MyDate();
 *
 * // 由JVM决定运行
 * If(JVM.内存不足()) {
 * date = null;
 * System.gc();
 * }
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference ref = new SoftReference(new MyDate());
        ReferenceTest.drainMemory();
    }
}
