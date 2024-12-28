package com.sk.netty.channel;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.net.InetSocketAddress;

/**
 * @Author: sukang
 * @Date: 2023/4/23 10:44
 * @Description:
 */
public interface IChannelClientMonitor {

    void setChannelClient(ChannelClient channelClient);

    void channelActive(ChannelHandlerContext ctx);

    void channelInactive(ChannelHandlerContext ctx);

    void exceptionCaught(ChannelHandlerContext ctx, Throwable cause);

    void connectFailure(InetSocketAddress inetSocketAddress);


}
