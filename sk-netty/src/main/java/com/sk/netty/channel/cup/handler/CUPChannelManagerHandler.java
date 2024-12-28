package com.sk.netty.channel.cup.handler;


import com.sk.netty.channel.ChannelClient;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;


/**
 * @Author: sukang
 * @Date: 2023/3/10 16:16
 * @Description:
 */
@Slf4j
public class CUPChannelManagerHandler extends ChannelInboundHandlerAdapter {



    private ChannelClient channelClient;

    public CUPChannelManagerHandler(ChannelClient channelClient) {
        this.channelClient = channelClient;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel active id is {} ", ctx.channel().id().asLongText());
        channelClient.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String action = String.valueOf(ctx.channel().attr(AttributeKey.valueOf("action")).get());
        log.info("channel inActive id is {}, action is {}  ", ctx.channel().id().asLongText(), action);

        if (!Objects.equals(action, "manually")) {
            channelClient.channelInactive(ctx);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("channel error ", cause);
        ctx.close();
    }

}
