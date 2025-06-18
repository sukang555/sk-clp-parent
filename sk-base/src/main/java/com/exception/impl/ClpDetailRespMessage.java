package com.exception.impl;

import com.exception.IExceptionMsgDetail;
import com.exception.RespMessage;

import java.util.Optional;

/**
 * @Author: sukang
 * @Date: 2021/12/13 17:35
 */
public enum  ClpDetailRespMessage implements IExceptionMsgDetail {


    SYSTEM_ERROR(RespMessage.SYS_ERROR,"0000001","Sys Error ","Sys Error"),
    /**
     *
     */
    BLOCK_ERROR(RespMessage.ILLEGAL_ARGUMENT,"1000001",
            "封锁码参数未找到 id = {}","block param can't be found, id is {}"),

    PARAM_ERROR(RespMessage.ILLEGAL_ARGUMENT, "1000002", "{}不合法", "{} is invalid ")


    ;

    private RespMessage respMessage;

    private String code;

    private String cnDetailMsg;

    private String enDetailMsg;

    ClpDetailRespMessage(RespMessage respMessage, String code, String cnDetailMsg, String enDetailMsg) {
        this.respMessage = respMessage;
        this.code = code;
        this.cnDetailMsg = cnDetailMsg;
        this.enDetailMsg = enDetailMsg;
    }

    @Override
    public String getCnDetailMsg() {
        return respMessage.getCnMsg() + ":" + cnDetailMsg;
    }

    @Override
    public String getEnDetailMsg() {
        return respMessage.getEnMsg() + ":" + enDetailMsg;
    }

    @Override
    public String getCode() {
        return Optional.ofNullable(respMessage.getCode()).orElse("")
                + Optional.ofNullable(code).orElse("");
    }
}
