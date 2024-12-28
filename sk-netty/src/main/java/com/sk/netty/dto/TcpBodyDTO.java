package com.sk.netty.dto;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.UUID;

/**
 * @Author: sukang
 * @Date: 2023/3/23 18:20
 * @Description:
 */

@ToString
@Slf4j
public class TcpBodyDTO<I,O> implements Serializable {

    private String uuid;

    private I reqData;

    private O respData;

    public static <I,O> TcpBodyDTO<I, O> getInstance(I data, Class<O> clazz){
        return new TcpBodyDTO<>(data);
    }

    public TcpBodyDTO() {
    }

    public TcpBodyDTO(I reqData) {
        this.uuid = UUID.randomUUID().toString();
        this.reqData = reqData;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public I getReqData() {
        return reqData;
    }

    public void setReqData(I reqData) {
        this.reqData = reqData;
    }

    public O getRespData() {
        return respData;
    }

    public void setRespData(O respData) {
        this.respData = respData;
    }
}
