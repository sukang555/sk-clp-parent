package com.exception;

/**
 * @Author: sukang
 * @Date: 2021/12/13 11:21
 */
public interface IExceptionMsgDetail {

    String getCnDetailMsg();


    String getEnDetailMsg();


    String getCode();


    default String getDetailMessage() {
        switch ("CN"){
            case "CN":
                return getCode() + ":" + getCnDetailMsg();
            case "EN":
                return getCode() + ":" + getEnDetailMsg();
            default:
                return getCode() + ":" + getCnDetailMsg();
        }
    }
}
