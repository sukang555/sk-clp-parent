package com.sk.server.run;

import com.sk.server.NettyServer;


/**
 * @Author: sukang
 * @Date: 2023/3/22 18:37
 * @Description:
 */

public class NettyServerRunning2 {

    public static void main(String[] args) {
        NettyServer.NettyServerBuilder.aNettyServer()
                .withPort(6668)
                .build()
                .start();
    }


}
