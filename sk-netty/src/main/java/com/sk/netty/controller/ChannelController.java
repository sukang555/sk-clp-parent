package com.sk.netty.controller;

import com.sk.netty.channel.ChannelClient;
import com.sk.netty.utils.InetSocketAddressUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: sukang
 * @Date: 2023-9-21 17:37
 * @Description:
 */
@RestController
@RequestMapping(value = "/channel")
public class ChannelController {

    @Resource
    private ChannelClient channelClient;


    @PutMapping(value = "/active/{host}")
    public Boolean active(@PathVariable("host") String host){
        return channelClient.activeConnection(InetSocketAddressUtils.getInetSocketAddress(host));
    }


    @PutMapping(value = "/inactive/{host}")
    public Boolean inActive(@PathVariable("host") String host) throws Exception{
        return channelClient.inActiveConnection(InetSocketAddressUtils.getInetSocketAddress(host));
    }


}
