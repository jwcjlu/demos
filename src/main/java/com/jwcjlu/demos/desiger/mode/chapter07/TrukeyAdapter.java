package com.jwcjlu.demos.desiger.mode.chapter07;
/**
 * <pre>
 * 
 *  File: TrukeyAdapter.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年5月10日				Jinwei				Initial.
 *
 * </pre>
 */
public class TrukeyAdapter implements Duck
{
    Trukey trukey;
    public TrukeyAdapter( Trukey trukey){
        this.trukey=trukey;
    }
    @Override
    public void quack()
    {
        // TODO Auto-generated method stub
        trukey.gobble();
    }

    @Override
    public void fly()
    {
        // TODO Auto-generated method stub
        for(int i=0;i<5;i++){
            trukey.fly();
        }
    }

}

