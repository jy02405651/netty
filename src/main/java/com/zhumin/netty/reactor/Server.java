package com.zhumin.netty.reactor;

public class Server {
    Demultiplexer selector = new Demultiplexer();
    EventDispatcher eventLooper = new EventDispatcher(selector);
    Acceptor acceptor;
    Server(int port) {
        acceptor = new Acceptor(selector, port);
    }
    public void start() {
        eventLooper.registEventHandler(EventType.ACCEPT,new AcceptEventHandler(selector));
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }
}
