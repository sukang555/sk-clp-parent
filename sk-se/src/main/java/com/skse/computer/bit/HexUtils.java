package com.skse.computer.bit;

import java.util.Arrays;

/**
 * ClassName HexUtils
 *
 * "".getbyte方法 获取的是字符串的
 *
 **/
public class HexUtils {
    /**
     * ascii码值 转16进制
     */
    public static String toHexString(String sourceStr){
        char[] chars = sourceStr.toCharArray();
        StringBuilder hexStringBuilder = new StringBuilder();
        for (char aChar : chars) {
            String str55 = Integer.toHexString(aChar).toUpperCase();
            if (str55.length() == 1){
                hexStringBuilder.append("0").append(str55);
            }else {
                hexStringBuilder.append(str55);
            }
        }

        return hexStringBuilder.toString();
    }



    public static String hexToAscii(String hex){
       byte[] bytes = transToBytes(hex);

       return new String(decimalToChar(bytes));
    }

    public static char[] decimalToChar(byte[] bytes) {
        int len = bytes.length;
        char[] chars = new char[len];
        for(int i=0; i<len; i++){
            chars[i]= (char)(bytes[i] & 0xff);
        }
        return chars;
    }

    /**
     * 16进制转10进制
     */
    public static byte[] transToBytes(String sourceStr) {
        int indexEnd = sourceStr.length()/2;
        byte[] bytes = new byte[indexEnd];

        for (int i = 0; i < indexEnd; i++) {
            String substring = sourceStr.substring(i * 2, (i + 1) * 2);
            bytes[i] = (byte)Integer.parseInt(substring, 16);
        }

        return bytes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString( "苏".getBytes()));

        System.out.println(toHexString("严"));

        System.out.println((int)'苏');
    }



}
