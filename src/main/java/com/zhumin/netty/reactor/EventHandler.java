package com.zhumin.netty.reactor;

abstract  class EventHandler {
    Source source;

    public abstract void handle(Event event);

    public Source getSource() {
        return source;
    }

}
