package com.sk.server;

import com.sk.netty.channel.demo.handler.JsonDecoder;
import com.sk.netty.channel.demo.handler.JsonEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: sukang
 * @Date: 2023/4/14 10:26
 * @Description:
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ch.pipeline()
                //in 顺序执行
                .addLast(new JsonDecoder())
                .addLast(new ServerChannelInboundHandler())
                //out 倒序执行
                .addLast(new JsonEncoder())
                .addLast(new ServerChannelOutboundResponse())
                ;
    }
}
