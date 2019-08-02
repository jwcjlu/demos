package com.jwcjlu.demos.desiger.mode.chapter03;
/**
 * <pre>
 * 
 *  File: Soy.java
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
public class Soy extends ComdimentDecorator {
	private Beverage beverage;
	public Soy(Beverage beverage){
		this.beverage=beverage;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+",Soy";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .10+beverage.cost();
	}

}

