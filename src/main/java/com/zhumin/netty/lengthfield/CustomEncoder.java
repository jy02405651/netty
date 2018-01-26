package com.zhumin.netty.lengthfield;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

/**
* 自定义编码器
* @author 朱敏
* @date 2018/1/19 0019 16:47
*/
public class CustomEncoder extends MessageToByteEncoder<CustomMsg> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, CustomMsg customMsg, ByteBuf byteBuf) throws Exception {
        if(null == customMsg){
            throw new Exception("msg is null");
        }

        String body = customMsg.getBody();
        byte[] bodyBytes = body.getBytes(Charset.forName("utf-8"));
        byteBuf.writeByte(customMsg.getType());
        byteBuf.writeByte(customMsg.getFlag());
        byteBuf.writeInt(bodyBytes.length);
        byteBuf.writeBytes(bodyBytes);

    }
}
