package com.exception;

/**
 * @Author: sukang
 * @Date: 2021/12/13 17:35
 */
public enum  RespMessage{
    /**
     *
     */
    SYS_ERROR("1001","数据库异常","db error"),
    DB_ERROR("1002","数据库异常","db error"),
    ILLEGAL_ARGUMENT("1003","参数异常","param error")
    ;

    private String code;

    private String cnMsg;

    private String enMsg;

    RespMessage(String code, String cnMsg, String enMsg) {
        this.code = code;
        this.cnMsg = cnMsg;
        this.enMsg = enMsg;
    }

    public String getCode() {
        return code;
    }


    public String getCnMsg() {
        return cnMsg;
    }


    public String getEnMsg() {
        return enMsg;
    }
}
