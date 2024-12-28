package com.sk.netty.channel.demo.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.pool.ChannelHealthChecker;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.channel.pool.FixedChannelPool;

/**
 * @Author: sukang
 * @Date: 2023/4/23 14:41
 * @Description:
 */
public class NettyChannelPool extends FixedChannelPool {

    private AcquireAction acquireAction = AcquireAction.FAILURE;

    public enum AcquireAction {
        /**
         *  该pool当前处于的状态 失败代表无可用channel
         */
        FAILURE,
        SUCCESS
    }


    public NettyChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler,
                            ChannelHealthChecker healthCheck,
                            AcquireTimeoutAction action,
                            long acquireTimeoutMillis,
                            int maxConnections,
                            int maxPendingAcquires,
                            boolean releaseHealthCheck,
                            boolean lastRecentUsed) {
        super(bootstrap, handler, healthCheck, action, acquireTimeoutMillis, maxConnections, maxPendingAcquires, releaseHealthCheck, lastRecentUsed);
    }

    public AcquireAction getAcquireAction() {
        return acquireAction;
    }

    public void setAcquireAction(AcquireAction acquireAction) {
        this.acquireAction = acquireAction;
    }


    public Boolean isFailure(){
        return this.acquireAction.equals(AcquireAction.FAILURE);
    }

}
