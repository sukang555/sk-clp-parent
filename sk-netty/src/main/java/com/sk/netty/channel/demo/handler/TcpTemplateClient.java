package com.sk.netty.channel.demo.handler;

import com.sk.netty.channel.ChannelClient;
import com.sk.netty.dto.TcpBodyCacheManager;
import com.sk.netty.dto.TcpBodyDTO;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;



/**
 * @Author: sukang
 * @Date: 2023/3/10 15:40
 * @Description:
 */
@Slf4j
public class TcpTemplateClient{

    private final ChannelClient channelClient;

    public TcpTemplateClient(ChannelClient channelClient) {
        this.channelClient = channelClient;
    }


    public void sendMsg(Object o) throws Exception {
        Channel channel = channelClient.getChannel(null);

        channel.writeAndFlush(o);

        channelClient.releaseChannel(channel);

    }







}
