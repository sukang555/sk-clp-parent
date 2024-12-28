package com.sk.netty.channel.cup.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sukang
 * @Date: 2023-9-20 18:58
 * @Description:
 */
@Slf4j
public class BizRouting {

    private static final ExecutorService executor = new ThreadPoolExecutor(64, 128, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(100000));


    public static void doBusiness(ChannelHandlerContext ctx, Object msg) {

        executor.submit(() -> {
            String allToHexStr = (String) msg;
            log.warn("接收客户端的16进制数据:{}", allToHexStr);

            String resp = "303333332e02303433313030303130303030202020303330333030303020202041410000303030303030303000303030303030323130e23e42818ac084100000000010000081313636323531393335313031303531313334333030303030303733313139343832363030353030373139343832363037333132393031303632383534313133353530303038393230313030303030383932303130303030303030303030303030303138303031323334353637383132333435363738393031323334353135363034303330303131353643303030303030303030303030333030323135364330303030303030313030303030333030303030303630303033303030303030303030303430313230303030303030383033303330303030303433353143533232303030303034353033313030303030202020303030303030303030303030303030303030303633373239463338";

            ctx.writeAndFlush(Unpooled.copiedBuffer(resp.getBytes()));
        });

    }
}
