package com.sk.netty.channel.cup.pool;

import com.sk.netty.channel.AbstractChannelClient;
import com.sk.netty.channel.ChannelClient;
import com.sk.netty.database.entity.ConnectionPoolInfo;
import com.sk.netty.database.entity.ConnectionPoolInfoMapper;
import io.netty.channel.Channel;
import io.netty.channel.pool.ChannelPool;
import io.netty.util.concurrent.FutureListener;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;

/**
 * @Author: sukang
 * @Date: 2023/4/17 14:45
 * @Description:
 */
@Slf4j
public class CUPReConnectTask extends Thread {


    private final ChannelClient channelClient;
    private final InetSocketAddress inetSocketAddress;

    private ScheduledFuture<?> scheduledFuture;

    public CUPReConnectTask(ChannelClient channelClient, InetSocketAddress inetSocketAddress) {
        this.channelClient = channelClient;
        this.inetSocketAddress = inetSocketAddress;
    }

    @Override
    public void run() {
        try {
            log.info("-----------------{} reConnectTask ----------------", inetSocketAddress.toString());

            if (scheduledFuture == null) {
                return;
            }

            AbstractChannelClient abstractChannelClient = (AbstractChannelClient) this.channelClient;

            if (!abstractChannelClient.getAbstractChannelPoolMap().contains(this.inetSocketAddress)){
                this.scheduledFuture.cancel(false);
                return;
            }


            ChannelPool channelPool = abstractChannelClient.getAbstractChannelPoolMap().get(inetSocketAddress);


            channelPool
                    .acquire()
                    .addListener((FutureListener<Channel>) future -> {
                        Channel channel;
                        if (future.isSuccess() && (channel = future.getNow()).isActive()) {
                            channelPool.release(channel);
                            this.scheduledFuture.cancel(false);
                            log.info("-{} ReConnect Success, {}-", inetSocketAddress, channel.id().asLongText());

                        }else {
                            log.info("-{} ReConnect Failure", inetSocketAddress);
                            ConnectionPoolInfo connectionPoolInfo = ConnectionPoolInfo.of(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
                            connectionPoolInfo.setConnectDateTime(LocalDateTime.now());
                            ConnectionPoolInfoMapper.replaceInto(connectionPoolInfo);
                        }

                    });
        } catch (Exception e) {
            log.error("re connect error ", e);
        }
    }

    public void setScheduledFuture(ScheduledFuture<?> scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }
}
