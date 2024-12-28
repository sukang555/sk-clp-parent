package com.sk.netty.channel.cup.pool;

import com.sk.netty.channel.ChannelClientBuilderHelper;
import com.sk.netty.channel.demo.pool.routing.IChannelRule;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: sukang
 * @Date: 2023/4/21 17:53
 * @Description:
 */
@Slf4j
public class CUPMultiChannelClientBuilder extends ChannelClientBuilderHelper<CUPMultiChannelClient> {

    private IChannelRule channelRule;

    @Override
    public CUPMultiChannelClient getObject() {
        CUPMultiChannelClient multiChannelClient = new CUPMultiChannelClient();
        multiChannelClient.setChannelRule(channelRule);
        multiChannelClient.setNettyClientProperties(nettyClientProperties);
        multiChannelClient.setIChannelClientMonitor(channelClientMonitor);
        multiChannelClient.getIChannelClientMonitor().setChannelClient(multiChannelClient);
        return multiChannelClient;
    }


    public CUPMultiChannelClientBuilder withChannelRule(IChannelRule channelRule) {
        this.channelRule = channelRule;
        return this;
    }


}
