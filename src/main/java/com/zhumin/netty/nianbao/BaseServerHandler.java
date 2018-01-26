package com.zhumin.netty.nianbao;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
* 服务端业务处理
* @author 朱敏
* @date 2018/1/19 0019 14:44
*/
public class BaseServerHandler extends ChannelInboundHandlerAdapter {

    private int counter;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body = (String)msg;
        System.out.println("server receive order : " + body + ";the counter is: " + ++counter);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
