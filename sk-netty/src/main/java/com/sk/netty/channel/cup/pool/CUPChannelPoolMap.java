package com.sk.netty.channel.cup.pool;


import com.sk.netty.channel.ChannelClient;
import com.sk.netty.channel.demo.pool.NettyChannelPool;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelHealthChecker;
import io.netty.channel.pool.ChannelPool;
import io.netty.channel.pool.FixedChannelPool;

import java.net.InetSocketAddress;


/**
 * @Author: sukang
 * @Date: 2023/4/20 14:05
 * @Description:
 */
public class CUPChannelPoolMap extends AbstractChannelPoolMap<InetSocketAddress, ChannelPool> {

    private final ChannelClient channelClient;


    public CUPChannelPoolMap(ChannelClient channelClient) {
        this.channelClient = channelClient;
    }

    @Override
    protected ChannelPool newPool(InetSocketAddress key) {

        return new NettyChannelPool(channelClient.getBootstrap().remoteAddress(key),
                new CUPChannelPoolHandler(channelClient),
                ChannelHealthChecker.ACTIVE,
                FixedChannelPool.AcquireTimeoutAction.NEW,
                channelClient.getNettyClientProperties().getConnectTimeout(),
                channelClient.getNettyClientProperties().getMaxConnections(),
                Integer.MAX_VALUE,
                true,
                false);
    }
}
