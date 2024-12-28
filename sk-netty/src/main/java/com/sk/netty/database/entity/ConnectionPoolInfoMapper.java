package com.sk.netty.database.entity;

import com.sk.netty.database.DataBaseManager;
import com.sk.netty.database.DatabaseTables;
import com.sk.netty.utils.BeanMapping;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @Author: sukang
 * @Date: 2023-9-20 11:14
 * @Description:
 */
public class ConnectionPoolInfoMapper {
    
    
    public static ConnectionPoolInfo getConnectInfoByUnionKey(String ip, int port){
        List<ConnectionPoolInfo> connectionInfos = DataBaseManager.getTable(DatabaseTables.CONNECT_INFO, ConnectionPoolInfo.class);

        return connectionInfos.stream()
                .filter(e -> Objects.equals(e.getIp(), ip) && Objects.equals(e.getPort(), port))
                .findFirst().orElse(null);

    }



    public static void replaceInto(ConnectionPoolInfo connectionInfo){
        ConnectionPoolInfo infoByUnionKey = getConnectInfoByUnionKey(connectionInfo.getIp(), connectionInfo.getPort());

        if (infoByUnionKey == null){
            insert(connectionInfo);
        }else {
            infoByUnionKey.setUpdateDateTime(LocalDateTime.now());

            if (StringUtils.isNotBlank(connectionInfo.getStatus())){
                infoByUnionKey.setStatus(connectionInfo.getStatus());
            }

            if (Objects.nonNull(connectionInfo.getConnectDateTime())){
                infoByUnionKey.setConnectDateTime(connectionInfo.getConnectDateTime());
            }

            if (StringUtils.isNotBlank(connectionInfo.getSource())){
                infoByUnionKey.setSource(connectionInfo.getSource());
            }

            if (Objects.nonNull(connectionInfo.getLastEchoDateTime())){
                infoByUnionKey.setLastEchoDateTime(connectionInfo.getLastEchoDateTime());
            }

            if (StringUtils.isNotBlank(connectionInfo.getLastEchoData())){
                infoByUnionKey.setLastEchoData(connectionInfo.getLastEchoData());
            }

            update(infoByUnionKey);
        }
    }

    private static void update(ConnectionPoolInfo connectionInfo){

        connectionInfo.setUpdateDateTime(LocalDateTime.now());
        ConnectionPoolInfo infoByUnionKey = getConnectInfoByUnionKey(connectionInfo.getIp(), connectionInfo.getPort());
        BeanMapping.copy(connectionInfo, infoByUnionKey);

    }


    private static void insert(ConnectionPoolInfo connectionInfo){

        List<ConnectionPoolInfo> connectionInfos = DataBaseManager.getTable(DatabaseTables.CONNECT_INFO, ConnectionPoolInfo.class);

        List<ConnectionPoolInfo> collect = connectionInfos.stream()
                .filter(e -> Objects.equals(e.getIp(),
                        connectionInfo.getIp()) && Objects.equals(e.getPort(), connectionInfo.getPort()))
                .collect(Collectors.toList());

        if (CollectionUtils.isNotEmpty(collect)){
            throw new IllegalArgumentException("ConnectionInfo duplicate key (ip, port )");
        }

        DataBaseManager.insertData(DatabaseTables.CONNECT_INFO, connectionInfo);
    }


    
}
