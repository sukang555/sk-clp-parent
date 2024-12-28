package com.sk.netty.channel.cup.pool;

import com.sk.netty.channel.cup.handler.CUPChannelBusinessHandler;
import com.sk.netty.channel.cup.handler.CUPChannelDecoderHandler;
import com.sk.netty.channel.cup.handler.CUPChannelManagerHandler;
import com.sk.netty.channel.cup.handler.CUPChannelResponseHandler;
import com.sk.netty.channel.ChannelClient;
import io.netty.channel.Channel;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;


/**
 * @Author: sukang
 * @Date: 2023/3/10 16:19
 * @Description:
 */
public class CUPChannelPoolHandler implements ChannelPoolHandler {

    private ChannelClient channelClient;

    static final EventExecutorGroup group = new DefaultEventExecutorGroup(16);

    public CUPChannelPoolHandler(ChannelClient channelClient) {
        this.channelClient = channelClient;
    }

    @Override
    public void channelReleased(Channel ch) throws Exception {

    }

    @Override
    public void channelAcquired(Channel ch) throws Exception {

    }

    @Override
    public void channelCreated(Channel ch) throws Exception {
        ch.pipeline()

                .addLast(new CUPChannelResponseHandler())

                .addLast(new CUPChannelDecoderHandler())
                .addLast(new CUPChannelManagerHandler(channelClient))
                .addLast(group, new CUPChannelBusinessHandler())
        ;
    }


}
