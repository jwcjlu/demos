package com.jwcjlu.demos.event;

/**
 * <pre>
 * 
 *  File: EventType.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年5月6日				Jinwei				Initial.
 *
 * </pre>
 */
public enum EventType
{
    open("关门"), close("开门");
    String desc;

    EventType(String desc)
    {
        this.desc = desc;
    }
}
