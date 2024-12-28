package com.sk.netty.dto;

import com.sk.netty.channel.demo.pool.NettyChannelPool;
import com.sk.netty.database.entity.ConnectionPoolInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: sukang
 * @Date: 2023-9-21 17:43
 * @Description:
 */

@Setter
@Getter
public class ConnectPoolDetailDTO {

    ConnectionPoolInfo connectionPoolInfo;


    NettyChannelPool nettyChannelPool;


}
