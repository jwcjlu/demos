package com.jwcjlu.demos.desiger.mode.chapter06.version01;
/**
 * <pre>
 * 
 *  File: LightOnCommand.java
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
public class LightOnCommand implements Command
{
    private Light light;
    public LightOnCommand(Light light){
        this.light=light;
    }

    @Override
    public void execute()
    {
        // TODO Auto-generated method stub
        light.on();
    }

}

