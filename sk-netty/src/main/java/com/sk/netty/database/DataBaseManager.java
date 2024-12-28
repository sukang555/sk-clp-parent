package com.sk.netty.database;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: sukang
 * @Date: 2023-9-20 10:57
 * @Description:
 */
public class DataBaseManager {

    /**
     * 表名字
     * 表数据 List
     */
    private static final Map<String, List<TableColumn>> DATA_BASES  = new ConcurrentHashMap<String, List<TableColumn>>(){{
        put(DatabaseTables.CONNECT_INFO, new ArrayList<>(16));
    }};



    public static <T> List<T> getTable(String tableName, Class<T> tClass){
        return (List<T>) Optional.ofNullable(DATA_BASES.get(tableName)).orElse(Collections.emptyList());
    }

    public static List<TableColumn> getTable(String tableName){
        return Optional.ofNullable(DATA_BASES.get(tableName)).orElse(Collections.emptyList());
    }




    public static void insertData(String tableName, TableColumn tableColumn){
        DATA_BASES.get(tableName).add(tableColumn);
    }


    public static void insertData(String tableName, List<TableColumn> tableColumn){
        DATA_BASES.get(tableName).addAll(tableColumn);
    }




}
