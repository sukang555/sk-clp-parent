package com.sk.netty.channel.demo.handler;


import com.google.gson.Gson;
import com.sk.netty.dto.TcpBodyDTO;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author: sukang
 * @Date: 2023/4/13 17:10
 * @Description:
 */
@Slf4j
public class JsonDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {

        int readableBytes = byteBuf.readableBytes();
        byte[] bytes = new byte[readableBytes];
        byteBuf.readBytes(bytes);

        TcpBodyDTO tcpBodyDTO = new Gson().fromJson(new String(bytes, CharsetUtil.UTF_8), TcpBodyDTO.class);
        out.add(tcpBodyDTO);
        log.info("json decoder end");
    }
}
