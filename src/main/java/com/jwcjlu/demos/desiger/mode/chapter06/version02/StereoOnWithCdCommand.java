package com.jwcjlu.demos.desiger.mode.chapter06.version02;
/**
 * <pre>
 * 
 *  File: StereoOnWithCdCommand.java
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
public class StereoOnWithCdCommand implements Command
{
  private Stereo stereo;
  public StereoOnWithCdCommand(Stereo stereo){
      this.stereo=stereo;
  }
    @Override
    public void execute()
    {
        // TODO Auto-generated method stub
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
        
    }

}

