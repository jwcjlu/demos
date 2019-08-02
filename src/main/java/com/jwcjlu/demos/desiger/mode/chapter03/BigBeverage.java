package com.jwcjlu.demos.desiger.mode.chapter03;
/**
 * <pre>
 * 
 *  File: BigBeverage.java
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
public class BigBeverage extends Beverage {
	private Beverage beverage;
	public BigBeverage(Beverage beverage){
		this.beverage=beverage;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+.20;
	}

}

