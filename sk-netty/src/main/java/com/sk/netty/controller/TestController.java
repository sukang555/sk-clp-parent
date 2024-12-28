package com.sk.netty.controller;

import com.sk.netty.channel.demo.handler.TcpTemplateClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: sukang
 * @Date: 2023/3/10 16:50
 * @Description:
 */
@RestController
public class TestController {



    @Resource
    private TcpTemplateClient tcpTemplateClient;


    @PostMapping(value = "/test/{msg}")
    public Object nettyClientPost(@PathVariable("msg") String msg) throws Exception {

        tcpTemplateClient.sendMsg(msg);

        return "SUCCESS";
    }



}
