package com.sk.netty.channel.demo.pool.routing;

import com.sk.netty.channel.AbstractChannelClient;
import com.sk.netty.channel.demo.pool.NettyChannelPool;
import io.netty.channel.Channel;


import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelPool;
import io.netty.util.concurrent.*;
import org.springframework.util.CollectionUtils;

import java.net.InetSocketAddress;
import java.security.SecureRandom;
import java.util.*;


/**
 * @Author: sukang
 * @Date: 2023/4/14 15:38
 * @Description:
 */
public class RandomChannelRule extends AbstractChannelRule {


    @Override
    public Future<Channel> getChannelFuture() throws Exception {

        AbstractChannelClient abstractChannelClient = (AbstractChannelClient) getChannelClient();
        AbstractChannelPoolMap<InetSocketAddress, ChannelPool> abstractChannelPoolMap = abstractChannelClient.getAbstractChannelPoolMap();

        List<InetSocketAddress> inetSocketAddressList = new ArrayList<>();
        Iterator<Map.Entry<InetSocketAddress, ChannelPool>> entryIterator = abstractChannelPoolMap.iterator();

        while(entryIterator.hasNext()){
            Map.Entry<InetSocketAddress, ChannelPool> channelPoolEntry = entryIterator.next();

            NettyChannelPool nettyChannelPool = (NettyChannelPool) channelPoolEntry.getValue();

            if (!nettyChannelPool.isFailure()){
                inetSocketAddressList.add(channelPoolEntry.getKey());
            }
        }

        if (CollectionUtils.isEmpty(inetSocketAddressList)){
            return null;
        }

        int nextInt = new SecureRandom().nextInt(inetSocketAddressList.size());

        return abstractChannelPoolMap
                .get(inetSocketAddressList.get(nextInt))
                .acquire();
    }

}
