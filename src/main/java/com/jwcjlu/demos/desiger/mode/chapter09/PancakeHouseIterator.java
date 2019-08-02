package com.jwcjlu.demos.desiger.mode.chapter09;

import java.util.Collection;

/**
 * <pre>
 * 
 *  File: PancakeHouseIterator.java
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
public class PancakeHouseIterator implements Iterator
{
    private java.util.Iterator<MenuItem> iter;
    public PancakeHouseIterator(Collection<MenuItem> coll){
        iter=coll.iterator();
    }

    @Override
    public boolean hasNext()
    {
        // TODO Auto-generated method stub
        return iter==null?false:iter.hasNext();
    }

    @Override
    public Object next()
    {
        // TODO Auto-generated method stub
        return iter.next();
    }

}

