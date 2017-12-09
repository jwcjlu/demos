package com.jwcjlu.demos.jetty.restful;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <pre>
 * 
 *  File: ConfigUtil.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年11月23日				jinwei				Initial.
 *
 * </pre>
 */
public final class ConfigUtil
{
    
    private static Properties properties;
     static {
        String fileSeparator = System.getProperty("file.separator");
        String classLoaderPath=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String configFilePath = classLoaderPath + (classLoaderPath.endsWith(fileSeparator)?"":fileSeparator)+ "conf" + fileSeparator + "ejob.properties";
        
        properties = new Properties();
        try {
            properties.load(new FileInputStream(configFilePath));
        } catch (final IOException ex) {
           
        }
      }
     /**
      * 
      * TODO.
      *
      * @param key
      * @param defaultValue
      * @return
      */
    public static String getProperty(String key,String defaultValue){
        return properties.getProperty(key, defaultValue);          
    }
    /**
     * 
     * TODO.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getProperty(String key,int defaultValue){
        int value=defaultValue;
        try{
            value=Integer.parseInt(properties.getProperty(key));
        }catch(Exception e){
        }
        return value;
    }
}

