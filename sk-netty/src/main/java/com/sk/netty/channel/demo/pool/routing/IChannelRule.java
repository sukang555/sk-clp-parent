package com.sk.netty.channel.demo.pool.routing;

import com.sk.netty.channel.ChannelClient;
import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;

/**
 * @Author: sukang
 * @Date: 2023/4/14 15:33
 * @Description:
 */
public interface IChannelRule {


    Future<Channel> getChannelFuture() throws Exception;

    ChannelClient getChannelClient();

    void setChannelClient(ChannelClient channelClient);


}
