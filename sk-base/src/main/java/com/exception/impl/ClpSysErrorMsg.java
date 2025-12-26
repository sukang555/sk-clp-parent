package com.exception.impl;

import com.exception.IExceptionMsgDetail;

/**
 * @Author: sukang
 * @Date: 2021/12/13 17:35
 */
public enum ClpSysErrorMsg implements IExceptionMsgDetail {


    SYSTEM_ERROR("100000","Sys Error ","Sys Error"),
    ;

    private final String code;

    private final String cnDetailMsg;

    private final String enDetailMsg;

    ClpSysErrorMsg(String code, String cnDetailMsg, String enDetailMsg) {
        this.code = code;
        this.cnDetailMsg = cnDetailMsg;
        this.enDetailMsg = enDetailMsg;
    }

    @Override
    public String getCnDetailMsg() {
        return this.cnDetailMsg;
    }

    @Override
    public String getEnDetailMsg() {
        return this.enDetailMsg;
    }

    @Override
    public String getCode() {
        return SYSTEM_ERROR_CODE + this.code;
    }
}
