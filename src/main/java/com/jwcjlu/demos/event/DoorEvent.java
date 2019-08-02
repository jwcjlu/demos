package com.jwcjlu.demos.event;

import java.util.EventObject;

public class DoorEvent extends EventObject {

    private static final long serialVersionUID = 6496098798146410884L;

    private EventType doorState;// 表示门的状态，有“开”和“关”两种

    public DoorEvent(Object source, EventType doorState) {
        super(source);
        this.doorState = doorState;
    }

    public void setDoorState(EventType doorState) {
        this.doorState = doorState;
    }

    public EventType getDoorState() {
        return this.doorState;
    }

}