package com.sk.netty.channel.cup.handler;

import com.sk.netty.database.entity.ConnectionPoolInfo;
import com.sk.netty.database.entity.ConnectionPoolInfoMapper;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: sukang
 * @Date: 2023-9-20 18:33
 * @Description:
 */
@Slf4j
public class CUPChannelBusinessHandler extends ChannelInboundHandlerAdapter {

    static final String CUP_MONITOR_HEART_BEAT_MESSAGE = "30303030";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (!Objects.equals(CUP_MONITOR_HEART_BEAT_MESSAGE, msg)){

            BizRouting.doBusiness(ctx, msg);


        }else {
            log.warn("收到心跳包:{}", msg);

            InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();

            ConnectionPoolInfo connectionInfo = new ConnectionPoolInfo(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
            connectionInfo.setLastEchoDateTime(LocalDateTime.now());
            connectionInfo.setLastEchoData(String.valueOf(msg));
            ConnectionPoolInfoMapper.replaceInto(connectionInfo);

            ctx.writeAndFlush(Unpooled.copiedBuffer(msg.toString().getBytes()));
        }

    }
}
