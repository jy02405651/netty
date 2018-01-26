package com.zhumin.netty.lengthfield;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class CustomClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        CustomMsg customMsg = new CustomMsg((byte)0xAB, (byte)0xCD, "Hello,Netty1".length(), "Hello,Netty1");
        ctx.writeAndFlush(customMsg);
        Thread.sleep(10000);
        String msg = "我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345我是消息！12345";

        CustomMsg customMsg2= new CustomMsg((byte)0xAB, (byte)0xCD, msg.length(), msg);
        ctx.writeAndFlush(customMsg2);
    }

}
