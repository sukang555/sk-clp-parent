package com.skse.computer.bit;

import org.junit.Test;

/**
 * 位运算 相关测试
 * @author sukang on 2019/11/26 10:55
 */
public class BitTest {


    /**
     * 消除一个数字的最后一个为1的位
     *
     *
     */
    @Test
    public void main2(){
        int value = -1;
        int num = 0;

        while (value != 0){
            value = value & (value -1);
            ++num;
        }

        System.out.println(num);
    }


    /**
     * 快速判断一个数是否是偶数
     *
     * 奇数的二进制位 最后一位是1
     *
     *  **** ***1
     *  **** ***1
     *
     *  **** ***0
     *  **** ***1
     *
     */
    @Test
    public void main1(){
        int num = 268;

        System.out.println((num & 1) != 1);
    }








}
