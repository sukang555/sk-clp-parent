package com.skse.serverio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sukang on 2019/7/30.
 */
@RestController
public class IndexHandler {


    @GetMapping(value = "/index")
    public String index(){
        return "{\"name\":\"sukang\"}";
    }
}
