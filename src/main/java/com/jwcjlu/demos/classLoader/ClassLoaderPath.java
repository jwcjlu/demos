package com.jwcjlu.demos.classLoader;

public class ClassLoaderPath {
    private static String path;
    public static void init(ClassLoader  loader){

    }


    public static String getPath() {
        return path;
    }

    public static void setPath(String filePath) {
       path = filePath;
    }
}
