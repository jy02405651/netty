package com.zhumin.netty.reconnect;

import io.netty.channel.ChannelHandler;


/**
* 保存handlers的一个接口
* @author 朱敏
* @date 2018/1/23 0023 21:24
*/
public interface IChannelHandler {

    ChannelHandler[] handlers();
}
