package com.jwcjlu.demos.desiger.mode.chapter06.version01;

/**
 * <pre>
 * 
 *  File: SimpleControl.java
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
public class SimpleRemoteControl
{
    private Command solt;

    public void setCommand(Command command)
    {
        this.solt = command;
    }

    public void buttonOnPressed()
    {
        solt.execute();
    }
}
