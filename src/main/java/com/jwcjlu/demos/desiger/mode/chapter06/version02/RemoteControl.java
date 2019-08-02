package com.jwcjlu.demos.desiger.mode.chapter06.version02;
/**
 * <pre>
 * 
 *  File: RemoteControl.java
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
public class RemoteControl
{
    private Command onCommands[];
    private Command offCommands[];
    public RemoteControl(){
        onCommands=new Command[7];
        offCommands=new Command[7];
    }
    void setCommand(int solt,Command onC,Command offC){
        onCommands[solt]=onC;
        offCommands[solt]=offC;
    }
    void onButtonWasPushed(int solt){
        onCommands[solt].execute();
    }
    void offButtonWasPushed(int solt){
        offCommands[solt].execute();
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<onCommands.length;i++){
            sb.append("[solt  "+i+"]").append(onCommands[i].getClass().getName())
            .append(offCommands[i].getClass().getName()).append("\n");
        }
        return sb.toString();
    }

}

