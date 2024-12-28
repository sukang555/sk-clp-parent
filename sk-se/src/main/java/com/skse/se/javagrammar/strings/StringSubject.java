package com.skse.se.javagrammar.strings;

import org.junit.Test;

/**
 * @author sukang on 2019/12/31 10:58
 */
public class StringSubject {



    @Test
    public void main1(){
        String x="7";
        int y = 2;
        int z=2;

        //字符串遇到+ 自动将另外一个操作数转为字符串 722
        System.out.println(x+y+z);
        //先进行数学运算 再进行拼接 47
        System.out.println(y + z + x);

    }
}
