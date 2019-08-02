package com.jwcjlu.demos.desiger.mode.chapter06.version02;
/**
 * <pre>
 * 
 *  File: CellingLightOnCommand.java
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
public class CellingLightOnCommand implements Command
{
 private CellingLight cellingLight;
 public CellingLightOnCommand(CellingLight cellingLight){
     this.cellingLight=cellingLight;
 }
    @Override
    public void execute()
    {
        // TODO Auto-generated method stub
        cellingLight.on();
        cellingLight.dim();
    }

}

