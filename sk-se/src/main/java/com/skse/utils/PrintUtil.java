package com.skse.utils;

import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * @author sukang on 2019/2/21.
 */
public class PrintUtil {

    public static void printArray(Integer[] ints){
        printArray(Arrays.asList(ints));
    }

    public static void printArray(int[] ints){
        printArray(Ints.asList(ints));
    }

    public static void  printArray(List<?> list){
        print(list);
    }

    private static void print(List<?> list){
        StringBuilder stringBuilder = new StringBuilder("{");
        list.forEach(t ->
                stringBuilder.append(t).append(",")
        );
        String s = StringUtils.removeEnd(stringBuilder.toString(), ",");
        System.out.println(s.concat("}"));
    }


    public static void printMap(Map<?,?> maps){

        for (Map.Entry<?, ?> entry : maps.entrySet()) {
            System.out.println(entry.getKey() + "::" + entry.getValue().toString());
        }
    }
}
