package com.sk.netty.utils;

import java.net.InetSocketAddress;

/**
 * @Author: sukang
 * @Date: 2023/4/20 11:06
 * @Description:
 */
public class InetSocketAddressUtils {

    public static InetSocketAddress getInetSocketAddress(String path) {

        String[] strings = path.split(":");
        int port = Integer.parseInt(strings[1]);

        return new InetSocketAddress(strings[0], port);
    }


}
