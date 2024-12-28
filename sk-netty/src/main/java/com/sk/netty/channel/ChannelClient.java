package com.sk.netty.channel;

import com.sk.netty.config.NettyClientProperties;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelPool;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

/**
 * @Author: sukang
 * @Date: 2023/4/21 17:41
 * @Description:
 */
public interface ChannelClient {


    /**
     * 释放channel
     * @param channel channel
     * @throws Exception 异常
     */
    void releaseChannel(Channel channel) throws Exception;

    void channelActive(ChannelHandlerContext ctx);

    void channelInactive(ChannelHandlerContext ctx);

    void exceptionCaught(ChannelHandlerContext ctx, Throwable cause);

    Boolean inActiveConnection(InetSocketAddress inetSocketAddress) throws ExecutionException, InterruptedException;

    Boolean activeConnection(InetSocketAddress inetSocketAddress);



    void init() throws Exception;


    NettyClientProperties getNettyClientProperties();

    AbstractChannelPoolMap<InetSocketAddress, ChannelPool> getAbstractChannelPoolMap();

    Channel getChannel(InetSocketAddress inetSocketAddress) throws Exception;

    Bootstrap getBootstrap();
}
