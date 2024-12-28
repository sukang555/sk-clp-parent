package com.sk.netty.channel.demo.pool.routing;

import com.sk.netty.channel.ChannelClient;

/**
 * @Author: sukang
 * @Date: 2023/4/23 13:39
 * @Description:
 */
public abstract class AbstractChannelRule implements IChannelRule{

    private ChannelClient channelClient;


    @Override
    public ChannelClient getChannelClient() {
        return channelClient;
    }

    @Override
    public void setChannelClient(ChannelClient channelClient) {
        this.channelClient = channelClient;
    }
}
