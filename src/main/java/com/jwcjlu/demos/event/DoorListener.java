package com.jwcjlu.demos.event;

import java.util.EventListener;

public interface DoorListener extends EventListener {
	public void doorEvent(DoorEvent event);
}
