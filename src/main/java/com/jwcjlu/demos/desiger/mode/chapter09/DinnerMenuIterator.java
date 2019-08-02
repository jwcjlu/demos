package com.jwcjlu.demos.desiger.mode.chapter09;
/**
 * <pre>
 * 
 *  File: DinnerMenuIterator.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年5月18日				Jinwei				Initial.
 *
 * </pre>
 */
public class DinnerMenuIterator implements Iterator
{
    private MenuItem[] menus;
    private int position=0;
    public DinnerMenuIterator(MenuItem[]menus){
        this.menus=menus;
    }
    @Override
    public boolean hasNext()
    {
        // TODO Auto-generated method stub
        if(menus==null||menus.length<position){
            return false;
        }
        return true;
    }

    @Override
    public Object next()
    {
        // TODO Auto-generated method stub
        MenuItem item=menus[position];
        position=position+1;
        return item;
    }

}

