package com.sk.netty.config;

import com.sk.netty.channel.ChannelClient;
import com.sk.netty.channel.cup.pool.CUPAutoConnectionMonitor;
import com.sk.netty.channel.cup.pool.CUPMultiChannelClientBuilder;
import com.sk.netty.channel.demo.handler.TcpTemplateClient;
import com.sk.netty.channel.demo.pool.routing.IChannelRule;
import com.sk.netty.channel.demo.pool.routing.RandomChannelRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: sukang
 * @Date: 2023/3/10 16:41
 * @Description:
 */
@Configuration
public class NettyClientAutoConfig {


    @Bean
    public IChannelRule dynamicRouting(){
        return new RandomChannelRule();
    }


    @Bean(initMethod = "init")
    public ChannelClient nettyChannelClient(NettyClientProperties cupNettyClientProperties,
                                             IChannelRule channelRule){

        return new CUPMultiChannelClientBuilder()
                .withChannelRule(channelRule)
                .withNettyClientProperties(cupNettyClientProperties)
                .withChannelClientMonitor(new CUPAutoConnectionMonitor())
                .build();
    }


    @Bean
    public TcpTemplateClient nettyClient(ChannelClient nettyChannelClient){
        return new TcpTemplateClient(nettyChannelClient);
    }


    @Bean
    @ConditionalOnMissingBean(IChannelRule.class)
    public IChannelRule loopRouting(){
        return new RandomChannelRule();
    }

}
