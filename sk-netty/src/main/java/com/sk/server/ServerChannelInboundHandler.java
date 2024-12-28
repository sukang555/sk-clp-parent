package com.sk.server;

import com.sk.netty.dto.TcpBodyDTO;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author sukang
 */
@Slf4j
public class ServerChannelInboundHandler extends SimpleChannelInboundHandler<TcpBodyDTO<Object,Object>> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, TcpBodyDTO<Object,Object> msg) throws InterruptedException {

        log.info("Server 收到的消息解码后为:  {} ",  msg);
        msg.setRespData(msg.getReqData());

        //在寻找outbind时从队列末尾开始往前找
        ctx.channel().writeAndFlush(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
      super.channelReadComplete(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ChannelId channelId = ctx.channel().id();

        log.info("channel active id is {}" , channelId.asLongText());
    }




    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
