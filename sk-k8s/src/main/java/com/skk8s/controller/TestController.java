package com.skk8s.controller;


import com.skk8s.kafka.MqSmsDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sukang
 */
@RestController
public class TestController {

    @Resource
    private MqSmsDemo mqSmsDemo;


    @GetMapping("/text")
    public String test(){
        return "hello world ";
    }




    @GetMapping("/mq")
    public String mq(){

        mqSmsDemo.sendMsgToSysDemoSync(String.valueOf(System.currentTimeMillis()),"hello world");

        return "hello world send mq ";
    }



}
