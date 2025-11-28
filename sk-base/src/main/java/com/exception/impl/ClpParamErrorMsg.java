package com.exception.impl;

import com.exception.IExceptionMsgDetail;

public enum ClpParamErrorMsg implements IExceptionMsgDetail {

    PARAM_ERROR("1000002", "请求入参{}不合法", "request param {} is invalid ")
    ;

    private final String code;

    private final String cnDetailMsg;

    private final String enDetailMsg;

    ClpParamErrorMsg(String code, String cnDetailMsg, String enDetailMsg) {
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
        return "COM:" + PARAM_ERROR_CODE + this.code;
    }
}
