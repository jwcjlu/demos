package com.jwcjlu.demos.desiger.mode.chapter06.version01;
/**
 * <pre>
 * 
 *  File: GarageDoorOpenCommand.java
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
public class GarageDoorOpenCommand implements Command
{
    private GarageDoor garageDoor;
    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor=garageDoor;
    }
    @Override
    public void execute()
    {
        garageDoor.on();
        
    }

}

