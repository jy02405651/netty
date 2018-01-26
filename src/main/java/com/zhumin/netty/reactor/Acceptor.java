package com.zhumin.netty.reactor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Acceptor implements Runnable {

    private int port; // server socket port
    private Demultiplexer selector;

    // 代表 serversocket
    private BlockingQueue<Source> sourceQueue = new LinkedBlockingQueue<Source>();

    Acceptor(Demultiplexer selector, int port) {
        this.selector = selector;
        this.port = port;
    }

    public void aNewConnection(Source source) {
        sourceQueue.offer(source);
    }

    public int getPort() {
        return this.port;
    }

    public void run() {
        while (true) {
            Source source = null;
            try {
                // 相当于 serversocket.accept()
                source = sourceQueue.take();
            } catch (InterruptedException e) {
                // ignore it;
            }
            if (source != null) {
                Event acceptEvent = new Event();
                acceptEvent.source = source;
                acceptEvent.type = EventType.ACCEPT;
                selector.addEvent(acceptEvent);
            }
        }

    }
}
