package com.sk.netty.channel.demo.handler;


import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: sukang
 * @Date: 2023/4/13 17:10
 * @Description:
 */
@Slf4j
public class JsonEncoder extends MessageToByteEncoder<Object> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        byte[] bytes = new Gson().toJson(msg).getBytes(CharsetUtil.UTF_8);
        out.writeBytes(bytes);
        log.info("json encoder end");
    }
}
