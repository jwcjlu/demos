package com.jwcjlu.demos.bytebuddy;

public class ContextManager {
    private static ThreadLocal<Long> CONTEXT = new ThreadLocal<Long>();
    public  static void set(Long time){
        CONTEXT.set(time);
    }
    public static  Long get(){
      return  CONTEXT.get();
    }


}
