package com.sk.netty.channel.cup.pool;

import com.sk.netty.channel.ChannelClient;
import com.sk.netty.channel.IChannelClientMonitor;
import com.sk.netty.channel.demo.pool.NettyChannelPool;
import com.sk.netty.database.entity.ConnectionPoolInfo;
import com.sk.netty.database.entity.ConnectionPoolInfoMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @Author: sukang
 * @Date: 2023/4/23 16:17
 * @Description:
 */
@Slf4j
public class CUPAutoConnectionMonitor implements IChannelClientMonitor {

    private ChannelClient channelClient;

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = new ScheduledThreadPoolExecutor(
            5,
            new DefaultThreadFactory("re connect"),
            new ThreadPoolExecutor.AbortPolicy()
    );


    @Override
    public void setChannelClient(ChannelClient channelClient) {
        this.channelClient = channelClient;
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) {

        NettyChannelPool nettyChannelPool = (NettyChannelPool) this.channelClient.getAbstractChannelPoolMap()
                .get((InetSocketAddress) ctx.channel().remoteAddress());

        nettyChannelPool.setAcquireAction(NettyChannelPool.AcquireAction.SUCCESS);


        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();

        ConnectionPoolInfo connectionInfo = new ConnectionPoolInfo(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
        connectionInfo.setStatus("S");
        connectionInfo.setSource(this.channelClient.getNettyClientProperties().getSource());
        connectionInfo.setConnectDateTime(LocalDateTime.now());
        ConnectionPoolInfoMapper.replaceInto(connectionInfo);

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        NettyChannelPool nettyChannelPool = (NettyChannelPool) channelClient.getAbstractChannelPoolMap()
                .get((InetSocketAddress) ctx.channel().remoteAddress());

        nettyChannelPool.setAcquireAction(NettyChannelPool.AcquireAction.FAILURE);

        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        ConnectionPoolInfo connectionInfo = new ConnectionPoolInfo(inetSocketAddress.getHostString(),
                inetSocketAddress.getPort());


        connectionInfo.setStatus("F");
        connectionInfo.setSource(channelClient.getNettyClientProperties().getSource());
        connectionInfo.setConnectDateTime(LocalDateTime.now());
        ConnectionPoolInfoMapper.replaceInto(connectionInfo);

        addAutoReconnectionTask((InetSocketAddress) ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

    }


    @Override
    public void connectFailure(InetSocketAddress inetSocketAddress) {

        ConnectionPoolInfo connectionInfo = new ConnectionPoolInfo(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
        connectionInfo.setStatus("F");
        connectionInfo.setSource(channelClient.getNettyClientProperties().getSource());
        connectionInfo.setConnectDateTime(LocalDateTime.now());
        ConnectionPoolInfoMapper.replaceInto(connectionInfo);

        addAutoReconnectionTask(inetSocketAddress);
    }




    private void addAutoReconnectionTask(InetSocketAddress inetSocketAddress) {
        CUPReConnectTask reConnectTask = new CUPReConnectTask(this.channelClient, inetSocketAddress);

        ScheduledFuture<?> scheduledFuture = SCHEDULED_EXECUTOR_SERVICE.scheduleWithFixedDelay(
                reConnectTask, 1000, this.channelClient.getNettyClientProperties().getReConnectRate(), TimeUnit.MILLISECONDS);

        reConnectTask.setScheduledFuture(scheduledFuture);
    }
}
