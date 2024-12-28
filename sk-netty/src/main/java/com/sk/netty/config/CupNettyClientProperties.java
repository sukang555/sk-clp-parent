package com.sk.netty.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: sukang
 * @Date: 2023-9-21 15:44
 * @Description:
 */
@ConfigurationProperties(prefix = "anytxn.cup.server")
public class CupNettyClientProperties extends NettyClientProperties{



}
