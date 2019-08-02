package com.jwcjlu.demos.desiger.mode.chapter03;
/**
 * <pre>
 * 
 *  File: StarbuzzCoffee.java
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
public class StarbuzzCoffee {
	public static void main(String[] args) {
		Beverage bever=new Espresso();
		System.out.println(bever.getDescription()+" $"+bever.cost());
		bever=new Soy(bever);
		bever=new Mecha(bever);
		bever=new Whip(bever);
		System.out.println(bever.getDescription()+" $"+bever.cost());
		Beverage bever1=new HouseBlend();
		bever1=new Soy(bever1);
		bever1=new Mecha(bever1);
		bever1=new Whip(bever1);
		System.out.println(bever1.getDescription()+" $"+bever1.cost());
		
	}
}

