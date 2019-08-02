package com.jwcjlu.demos.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * 
 *  File: WeightRoundRobin.java
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
public class WeightRoundRobin
{
    private static Integer pos = 0;

    public static String getServer()
    {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<Key> serverList = new ArrayList<Key>();
        int tempWeight = 0;
        int minWeight=Integer.MAX_VALUE;
        while (iterator.hasNext())
        {
            String server = iterator.next();
            int weight = serverMap.get(server);
            tempWeight += weight;
            minWeight=Math.min(minWeight, weight);
            Key key = new Key(tempWeight,server);
            serverList.add(key);

        }

        String server = null;
        synchronized (pos)
        {
            if (pos >=(tempWeight/minWeight))
                pos = 0;
            for(Key key:serverList){
                if((key.getMaxValue()/minWeight)>pos){
                    server=key.getServer();
                    break;
                }
            }
            pos++;
        }

        return server;
    }
    
    public static void main(String[] args)
    {
        Map<String,Integer>map=new HashMap<String,Integer>();
        for (int i = 0; i < 85; i++)
        {
            System.out.println(getServer());
            if((i+1)%17==0){
                System.out.println("----------------------------------------------------");
            }
            
        }
        
    }
}

class Key
{

    private int maxValue;
    private String server;

    public Key(int maxValue,String server)
    {
        this.maxValue = maxValue;
        this.server=server;
    }

    public int getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(int maxValue)
    {
        this.maxValue = maxValue;
    }

    public String getServer()
    {
        return server;
    }

    public void setServer(String server)
    {
        this.server = server;
    }

    @Override
    public String toString()
    {
        return "Key [maxValue=" + maxValue + ", server=" + server + "]";
    }

}