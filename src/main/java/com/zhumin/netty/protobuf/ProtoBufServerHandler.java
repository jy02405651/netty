package com.zhumin.netty.protobuf;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.List;

/**
* 服务端业务处理Handler
* @author 朱敏
* @date 2018/1/20 0020 21:33
*/
public class ProtoBufServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RichManProto.RichMan req = (RichManProto.RichMan) msg;
        System.out.println(req.getName()+"他有"+req.getCarsCount()+"量车");
        List<RichManProto.RichMan.Car> lists = req.getCarsList();
        if(null != lists) {

            for(RichManProto.RichMan.Car car : lists){
                System.out.println(car.getName());
            }
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
