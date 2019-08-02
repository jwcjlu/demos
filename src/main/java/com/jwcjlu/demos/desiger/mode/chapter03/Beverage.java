package com.jwcjlu.demos.desiger.mode.chapter03;
/**
 * 
 * <pre>
 * 
 *  File: Beverage.java
 * 
 *  Copyright (c) 2017, globalegrow.com All Rights Reserved.
 * 
 *  Description:
 *  TODO
 * 
 *  Revision History
 *  Date,					Who,					What;
 *  2017年5月4日				Jinwei				Initial.
 *
 * </pre>
 */
public abstract class Beverage {
	enum Size{
		TALL,GRANDE,VENTI
	}
	Size size;
	String description="Unkown description";
	public String getDescription(){
		return description;
	}
   public abstract double cost();
   public Size getSize(){
	   return Size.GRANDE;
   }
}
