package com.jwcjlu.demos.reference;

import java.util.Date;

/**
 * Created by jwcjlu on 2019/9/4.
 *
 */
public class MyDate extends Date {

    /** Creates a new instance of MyDate */
    public MyDate() {
    }
    // 覆盖finalize()方法
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("obj [Date: " + this.getTime() + "] is gc");
    }

    public String toString() {
        return "Date: " + this.getTime();
    }
}
