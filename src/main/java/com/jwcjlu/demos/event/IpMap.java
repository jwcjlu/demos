package com.jwcjlu.demos.event;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 
 *  File: IpMap.java
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
public class IpMap
{
 // 待路由的Ip列表，Key代表Ip，Value代表该Ip的权重
    public static Map<String, Integer> serverWeightMap = 
            new HashMap<String, Integer>();
    
    static
    {
        serverWeightMap.put("192.168.1.100", 100);
        serverWeightMap.put("192.168.1.101", 100);
        // 权重为4
        serverWeightMap.put("192.168.1.102", 400);
        serverWeightMap.put("192.168.1.103", 100);
        serverWeightMap.put("192.168.1.104", 100);
        // 权重为3
        serverWeightMap.put("192.168.1.105", 300);
        serverWeightMap.put("192.168.1.106", 100);
        // 权重为2
        serverWeightMap.put("192.168.1.107", 200);
        serverWeightMap.put("192.168.1.108", 100);
        serverWeightMap.put("192.168.1.109", 100);
        serverWeightMap.put("192.168.1.110", 100);
    }
}

