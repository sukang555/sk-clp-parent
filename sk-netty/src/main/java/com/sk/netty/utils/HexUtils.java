package com.sk.netty.utils;

import org.apache.commons.codec.binary.Hex;

/**
 * @Author: sukang
 * @Date: 2023-9-27 15:30
 * @Description:
 */
public class HexUtils {

    public static String hexToAscii(String hex) throws Exception{
        byte[] bytes = Hex.decodeHex(hex);

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


}
