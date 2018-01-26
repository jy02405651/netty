package com.zhumin.netty.reactor;

public class AcceptEventHandler extends EventHandler {

    private Demultiplexer selector;

    public AcceptEventHandler( Demultiplexer selector){
        this.selector = selector;
    }

    public void handle(Event event) {
        if (event.type == EventType.ACCEPT) {
            Event readEvent = new Event();
            readEvent.source = event.source;
            readEvent.type = EventType.READ;
            selector.addEvent(readEvent);
        }


    }
}
