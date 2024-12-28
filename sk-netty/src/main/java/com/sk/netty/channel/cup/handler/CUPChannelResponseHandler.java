package com.sk.netty.channel.cup.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;
import org.jpos.iso.ISOUtil;


@Slf4j
public class CUPChannelResponseHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {

        ByteBuf byteBuf = (ByteBuf)msg;
        byte[] msgBytes = new byte[byteBuf.capacity()];
        byteBuf.readBytes(msgBytes);
        String msgStr = new String(msgBytes);

        log.warn("返回给模拟器的报文为：{}", msgStr);

        byte[] bytes = ISOUtil.hex2byte(msgStr);
        ByteBuf respByteBuf = Unpooled.copiedBuffer(bytes);
        ctx.write(respByteBuf);
        ctx.flush();

    }
}
