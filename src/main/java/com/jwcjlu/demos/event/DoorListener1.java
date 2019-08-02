package com.jwcjlu.demos.event;

public class DoorListener1 implements DoorListener {

	@Override
	public void doorEvent(DoorEvent event) {
		// TODO Auto-generated method stub
		  
		        // TODO Auto-generated method stub
		        if (event.getDoorState() != null && event.getDoorState()==EventType.open) {
		            System.out.println("门1打开");
		        } else {
		            System.out.println("门1关闭");
		        
		    }

	}

}
