package com.sk.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: sukang
 * @Date: 2023/3/11 15:43
 * @Description:
 *
 *  1 ChannelInboudHadnler
 *       按照添加顺序正序执行
 *  2 ChannelOutboundHandler
 *       按照添加顺序倒序执行
 *
 */
@Slf4j
public class NettyServer {

    private Integer port;

    public NettyServer(Integer port) {
        this.port = port;
    }


    public void start() {

        EventLoopGroup bossEventLoopGroup = new NioEventLoopGroup(1);

        EventLoopGroup workEventLoopGroup = new NioEventLoopGroup(4);


        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossEventLoopGroup, workEventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ServerChannelInitializer());

            ChannelFuture channelFuture = bootstrap.bind(this.port).sync();
            log.info("netty server start success, port is  {}", this.port);


            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossEventLoopGroup.shutdownGracefully();
            workEventLoopGroup.shutdownGracefully();
        }


    }


    public static final class NettyServerBuilder {
        private Integer port;

        private NettyServerBuilder() {
        }

        public static NettyServerBuilder aNettyServer() {
            return new NettyServerBuilder();
        }

        public NettyServerBuilder withPort(Integer port) {
            this.port = port;
            return this;
        }

        public NettyServer build() {
            return new NettyServer(port);
        }
    }
}
