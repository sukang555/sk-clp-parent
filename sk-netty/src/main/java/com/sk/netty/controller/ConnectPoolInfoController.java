package com.sk.netty.controller;

import com.sk.netty.channel.ChannelClient;
import com.sk.netty.channel.demo.pool.NettyChannelPool;
import com.sk.netty.database.DataBaseManager;
import com.sk.netty.database.DatabaseTables;
import com.sk.netty.database.TableColumn;
import com.sk.netty.database.entity.ConnectionPoolInfo;
import com.sk.netty.database.entity.ConnectionPoolInfoMapper;
import com.sk.netty.dto.ConnectPoolDetailDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Author: sukang
 * @Date: 2023/4/21 15:26
 * @Description:
 */
@RestController
@RequestMapping(value = "/connect-pool")
public class ConnectPoolInfoController {


    @Resource
    private ChannelClient channelClient;


    @GetMapping(value = "/list")
    public List<TableColumn> getDatabaseTables() {
        return DataBaseManager.getTable(DatabaseTables.CONNECT_INFO);
    }


    @GetMapping(value = "/detail/{ip}/{port}")
    public ConnectPoolDetailDTO getDataDetails(@PathVariable("ip") String ip,
                                               @PathVariable("port") Integer port) {

        ConnectionPoolInfo connectInfoByUnionKey = ConnectionPoolInfoMapper.getConnectInfoByUnionKey(ip, port);

        ConnectPoolDetailDTO connectPoolDetailDTO = new ConnectPoolDetailDTO();
        connectPoolDetailDTO.setConnectionPoolInfo(connectInfoByUnionKey);


        NettyChannelPool channelPool = (NettyChannelPool) channelClient.getAbstractChannelPoolMap().get(new InetSocketAddress(ip, port));


        connectPoolDetailDTO.setNettyChannelPool( channelPool);
        return connectPoolDetailDTO;


    }


}
