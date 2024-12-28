package com.sk.netty.config;


import lombok.Getter;

/**
 * @Author: sukang
 * @Date: 2023/4/17 17:04
 * @Description:
 *
 * 时间单位统一都为ms
 */

@Getter
public class NettyClientProperties {

    private String source;

    private String hosts;

    private int maxConnections = 1;

    private int connectTimeout = 3000;

    private int readTimeout = 5000;


    private int reConnectRate = 5000;

    public void setSource(String source) {
        this.source = source;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public void setReConnectRate(int reConnectRate) {
        this.reConnectRate = reConnectRate;
    }
}
