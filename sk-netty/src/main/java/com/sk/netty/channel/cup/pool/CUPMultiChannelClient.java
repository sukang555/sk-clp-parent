package com.sk.netty.channel.cup.pool;


import com.sk.netty.channel.AbstractChannelClient;
import com.sk.netty.channel.demo.pool.routing.IChannelRule;
import io.netty.channel.Channel;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelPool;
import io.netty.util.concurrent.FutureListener;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @Author: sukang
 * @Date: 2023/4/17 16:57
 * @Description:
 */
@Setter
@Getter
@Slf4j
public class CUPMultiChannelClient extends AbstractChannelClient {

    private IChannelRule channelRule;


    public void setChannelRule(IChannelRule channelRule) {
        this.channelRule = channelRule;
        this.channelRule.setChannelClient(this);
    }

    @Override
    public Channel getChannel() throws Exception {
        return this.channelRule
                .getChannelFuture()
                .get(this.nettyClientProperties.getConnectTimeout(), TimeUnit.MILLISECONDS);
    }


    @Override
    public AbstractChannelPoolMap<InetSocketAddress, ChannelPool> initChannelPoolMap() {
        return new CUPChannelPoolMap(this);
    }



    /**
     * 在内存中记录初始化链接信息
     */
    public void afterInit(){
        for (Map.Entry<InetSocketAddress, ChannelPool> channelPoolEntry : abstractChannelPoolMap) {

            channelPoolEntry.getValue().acquire().addListener((FutureListener<Channel>) future -> {
                Channel channel;

                if (future.isSuccess() && ( channel = future.getNow()).isActive()) {
                    log.error("channel init success {}", channelPoolEntry.getKey().toString());
                    channelPoolEntry.getValue().release(channel);
                }else {
                    log.error("channel init failure ", future.cause());
                    iChannelClientMonitor.connectFailure(channelPoolEntry.getKey());
                }
            });
        }
    }



}
