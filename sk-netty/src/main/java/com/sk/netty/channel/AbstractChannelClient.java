package com.sk.netty.channel;

import com.exception.ClpExceptionUtils;
import com.sk.netty.config.NettyClientProperties;
import com.sk.netty.utils.InetSocketAddressUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelPool;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: sukang
 * @Date: 2023/4/23 09:36
 * @Description:
 */
@Setter
@Getter
@Slf4j
public abstract class AbstractChannelClient implements ChannelClient {

    protected NettyClientProperties nettyClientProperties;

    protected List<InetSocketAddress> inetSocketAddressList;

    protected Bootstrap bootstrap;

    protected AbstractChannelPoolMap<InetSocketAddress, ChannelPool> abstractChannelPoolMap;

    protected IChannelClientMonitor iChannelClientMonitor;


    public void init() throws Exception {

        initInetSocketAddressList();

        initBootstrap();

        this.abstractChannelPoolMap = initChannelPoolMap();

        connectHost();

        afterInit();
    }

    public abstract AbstractChannelPoolMap<InetSocketAddress, ChannelPool> initChannelPoolMap();


    public abstract void afterInit() throws Exception;

    public abstract Channel getChannel() throws Exception;



    public void connectHost() {
        this.inetSocketAddressList.forEach(abstractChannelPoolMap::get);
    }


    public void initInetSocketAddressList() {
        this.inetSocketAddressList = Arrays.stream(
                        nettyClientProperties.getHosts().split(","))
                .map(InetSocketAddressUtils::getInetSocketAddress)
                .collect(Collectors.toList());
    }


    public void initBootstrap() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap strap = new Bootstrap();
        strap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true);

        this.bootstrap = strap;
    }

    /**
     * 获取channel实现, 如果绑定rule则通过rule获取
     * @return Channel {@link Channel}
     */


    public Channel getChannel(InetSocketAddress inetSocketAddress) throws Exception {

        if (inetSocketAddress != null){
            return this.abstractChannelPoolMap
                    .get(inetSocketAddress)
                    .acquire()
                    .get(this.nettyClientProperties.getConnectTimeout(), TimeUnit.MILLISECONDS);
        }
        Channel channel = getChannel();

        if (channel == null){
            ClpExceptionUtils.throwStringException().throwException("Can't get a valid channel ");
        }

        return channel;
    }

    @Override
    public void releaseChannel(Channel channel) {
        abstractChannelPoolMap.get((InetSocketAddress) channel.remoteAddress()).release(channel);
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        this.iChannelClientMonitor.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        this.iChannelClientMonitor.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        this.iChannelClientMonitor.exceptionCaught(ctx, cause);
    }


    @Override
    public Boolean inActiveConnection(InetSocketAddress inetSocketAddress) throws ExecutionException, InterruptedException {

        if (!this.abstractChannelPoolMap.contains(inetSocketAddress)){
            return false;
        }

        ChannelPool channelPool = this.abstractChannelPoolMap.get(inetSocketAddress);

        Channel channel = channelPool.acquire().get();
        channel.attr(AttributeKey.valueOf("action")).set("manually");
        channel.close();
        channelPool.close();

        abstractChannelPoolMap.remove(inetSocketAddress);

        return true;
    }

    @Override
    public Boolean activeConnection(InetSocketAddress inetSocketAddress) {

        if (!abstractChannelPoolMap.contains(inetSocketAddress)){
            abstractChannelPoolMap.get(inetSocketAddress);
        }

        iChannelClientMonitor.connectFailure(inetSocketAddress);

        return true;
    }




}
