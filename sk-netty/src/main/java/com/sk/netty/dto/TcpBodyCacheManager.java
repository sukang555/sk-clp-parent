package com.sk.netty.dto;


import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


/**
 * @Author: sukang
 * @Date: 2023/3/27 11:14
 * @Description:
 */
public class TcpBodyCacheManager {
    private static final Map<String, CompletableFuture<TcpBodyDTO<?, ?>>> TCP_BODY_DTO_MAP = new ConcurrentHashMap<>();


    public static void addReqBody(TcpBodyDTO<?, ?> tcpBodyDTO){
        CompletableFuture<TcpBodyDTO<?, ?>> completableFuture = new CompletableFuture<>();
        TCP_BODY_DTO_MAP.put(tcpBodyDTO.getUuid(), completableFuture);
    }


    public static <I,O> TcpBodyDTO<I, O> getRespBody(TcpBodyDTO<I, O> tcpBodyDTO, int readTimeout) throws Exception {
        CompletableFuture<TcpBodyDTO<?, ?>> tcpBodyDtoCompletableFuture = TCP_BODY_DTO_MAP.get(tcpBodyDTO.getUuid());
        if (tcpBodyDtoCompletableFuture == null){
            return null;
        }

        TcpBodyDTO<I, O> ioTcpBodyDTO = (TcpBodyDTO<I, O>) tcpBodyDtoCompletableFuture.get(readTimeout, TimeUnit.MILLISECONDS);

        if (ioTcpBodyDTO != null){
            TCP_BODY_DTO_MAP.remove(tcpBodyDTO.getUuid());
        }
        return ioTcpBodyDTO;
    }

    public static <I, O> void failureRequest(TcpBodyDTO<I,O> tcpBodyDTO) {
        TCP_BODY_DTO_MAP.get(tcpBodyDTO.getUuid()).complete(null);
    }


    public static void complete(TcpBodyDTO<Object, Object> tcpBodyDTO) {
        TCP_BODY_DTO_MAP.get(tcpBodyDTO.getUuid()).complete(tcpBodyDTO);
    }
}
