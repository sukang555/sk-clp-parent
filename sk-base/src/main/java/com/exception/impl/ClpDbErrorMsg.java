package com.exception.impl;

import com.exception.IExceptionMsgDetail;

public enum ClpDbErrorMsg implements IExceptionMsgDetail {
    DB_EFFECT_LINE_ERROR("100000","数据库操作行数错误,实际={},预期={}", "The number of " +
            "rows affected by the database operation does not match expectations.Actual={}, Expected={}")

    ;

    private final String code;

    private final String cnDetailMsg;

    private final String enDetailMsg;

    ClpDbErrorMsg(String code, String cnDetailMsg, String enDetailMsg) {
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
        return DB_ERROR_CODE + this.code;
    }
}
