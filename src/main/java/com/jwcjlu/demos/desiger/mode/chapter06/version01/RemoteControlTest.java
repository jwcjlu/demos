package com.jwcjlu.demos.desiger.mode.chapter06.version01;
/**
 * <pre>
 * 
 *  File: RemoteControlTest.java
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
public class RemoteControlTest
{
public static void main(String[] args)
{
    SimpleRemoteControl control=new SimpleRemoteControl();
    Command light=new LightOnCommand(new Light());
    Command garageDoor=new GarageDoorOpenCommand(new GarageDoor());
    control.setCommand(light);
    control.buttonOnPressed();
    control.setCommand(garageDoor);
    control.buttonOnPressed();
}
}

