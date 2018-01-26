package com.zhumin.netty.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
* 分发器
* @author 朱敏
* @date 2018/1/26 0026 11:35
*/
public class Demultiplexer {

    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();
    //对象锁
    private Object lock = new Object();

    List<Event> select() {
        return select(0);
    }

    List<Event> select(long timeout) {
        if (timeout > 0) {
            if (eventQueue.isEmpty()) {
                try {
                    lock.wait(timeout);
                } catch (InterruptedException e) {
                    // ignore it
                }
            }
        }
        List<Event> events = new ArrayList<Event>();
        eventQueue.drainTo(events);
        return events;
    }

    public void addEvent(Event e) {
        boolean success = eventQueue.offer(e);
        if(success){
            synchronized (lock) {
                lock.notify();
            }
        }
    }




}
