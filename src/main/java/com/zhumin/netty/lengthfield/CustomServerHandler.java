package com.zhumin.netty.lengthfield;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
* 服务端业务处理
* @author 朱敏
* @date 2018/1/19 0019 16:44
*/
public class CustomServerHandler extends SimpleChannelInboundHandler<Object> {
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        if(msg instanceof CustomMsg) {
            CustomMsg customMsg = (CustomMsg)msg;
            System.out.println("Client->Server:"+channelHandlerContext.channel().remoteAddress()+" send "+customMsg.getBody());
        }
    }
}
