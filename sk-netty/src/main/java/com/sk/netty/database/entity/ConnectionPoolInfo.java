package com.sk.netty.database.entity;

import com.sk.netty.database.TableColumn;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

/**
 * @Author: sukang
 * @Date: 2023-9-20 10:56
 * @Description:
 *
 *  IP + port 是唯一索引
 */
@Setter
@Getter
public class ConnectionPoolInfo extends TableColumn {


    private String ip;

    private String source;

    private int port;

    /**
     *  S- Success
     *  F - Failure
     */
    private String status;

    private LocalDateTime connectDateTime;

    private LocalDateTime lastEchoDateTime;

    private String lastEchoData;

    public ConnectionPoolInfo(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public static ConnectionPoolInfo of(String ip, int port) {
        Assert.hasLength(ip, "IP must not be empty ");

        return new ConnectionPoolInfo(ip, port);
    }
}
