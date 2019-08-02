package com.jwcjlu.demos.desiger.mode.chapter03;
/**
 * <pre>
 * 
 *  File: Whip.java
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
public class Whip extends ComdimentDecorator {
	private Beverage beverage;
	public Whip(Beverage beverage){
		this.beverage=beverage;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+",Whip";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+.25;
	}

}

