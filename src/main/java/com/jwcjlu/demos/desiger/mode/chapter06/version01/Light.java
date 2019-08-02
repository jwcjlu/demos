package com.jwcjlu.demos.desiger.mode.chapter06.version01;

/**
 * <pre>
 * 
 *  File: Light.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年5月9日				Jinwei				Initial.
 *
 * </pre>
 */
public class Light
{
    private String name;

    public Light()
    {

    }

    public Light(String name)
    {
        this.name = name;
    }

    public void on()
    {
        System.out.println("Light is on");
    }

    public void off()
    {
        System.out.println("Light is off ");
    }
}
