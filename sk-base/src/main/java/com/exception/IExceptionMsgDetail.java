package com.exception;

import java.util.Objects;

/**
 * @Author: sukang
 * @Date: 2021/12/13 11:21
 */
public interface IExceptionMsgDetail {

    String SYSTEM_ERROR_CODE = "101";
    String PARAM_ERROR_CODE = "102";
    String DB_ERROR_CODE = "103";

    String getCnDetailMsg();


    String getEnDetailMsg();


    String getCode();


    default String getDetailMessage() {
        if (Objects.equals("","EN")){
            return getCode() + ":" + getEnDetailMsg();
        }
        return getCode() + ":" + getCnDetailMsg();
    }
}
