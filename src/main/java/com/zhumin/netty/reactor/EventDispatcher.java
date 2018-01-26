package com.zhumin.netty.reactor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* event种类分离器
* @author 朱敏
* @date 2018/1/26 0026 13:36
*/
public class EventDispatcher {

    Map<EventType, EventHandler> eventHandlerMap = new ConcurrentHashMap<EventType, EventHandler>();

    Demultiplexer selector;

    EventDispatcher(Demultiplexer selector) {
        this.selector = selector;
    }

    public void registEventHandler(EventType eventType, EventHandler eventHandler) {
        eventHandlerMap.put(eventType, eventHandler);

    }

    public void removeEventHandler(EventType eventType) {
        eventHandlerMap.remove(eventType);
    }

    public void handleEvents() {
        dispatch();
    }

    private void dispatch() {
        while (true) {
            List<Event> events = selector.select();

            for (Event event : events) {
                EventHandler eventHandler = eventHandlerMap.get(event.type);
                eventHandler.handle(event);
            }
        }
    }
}
