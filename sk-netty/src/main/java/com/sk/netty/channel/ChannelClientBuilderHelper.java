package com.sk.netty.channel;

import com.sk.netty.config.NettyClientProperties;
import io.netty.bootstrap.Bootstrap;


/**
 * @author sukan
 *   Channel Clinet 和 Channel Monitor 一一 对应;
 */
public abstract class ChannelClientBuilderHelper<E extends ChannelClient> {

    protected NettyClientProperties nettyClientProperties;

    protected IChannelClientMonitor channelClientMonitor;


    public ChannelClientBuilderHelper<E> withNettyClientProperties(NettyClientProperties nettyClientProperties) {
        this.nettyClientProperties = nettyClientProperties;
        return this;
    }

    public ChannelClientBuilderHelper<E> withChannelClientMonitor(IChannelClientMonitor channelClientMonitor) {
        this.channelClientMonitor = channelClientMonitor;
        return this;
    }


    public E build(){
        return getObject();
    }

    /**
     *  创建具体的对象实例
     * @return 通过new 创建对象
     */
    protected abstract E getObject();


}
