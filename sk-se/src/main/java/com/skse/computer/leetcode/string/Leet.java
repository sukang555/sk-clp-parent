package com.skse.computer.leetcode.string;

import org.junit.Test;
import com.skse.utils.PrintUtil;

import java.util.Objects;


/**
 * @author sukang on 2019/2/2.
 */
public class Leet {


    @Test
    public void main2(){

        System.out.println(strStr("mississippi","pi"));

        "".replace("","");

    }


    public int climbStairs(int n) {
        if (n <= 1){
            return 1;
        }
        int[] ints = new int[n];

        ints[0] = 1;
        ints[1] = 2;

        for (int i = 2; i < n; i++) {
            ints[i] = ints[i - 1] + ints[i-2];
        }

        return ints[ints.length - 1];
    }




    public int strStr(String haystack, String needle) {

        if (Objects.equals(needle,"") || Objects.equals(needle,haystack)){
            return 0;
        }

        int indexStart = 0;
        int indexEnd = indexStart + needle.length();

        while (indexStart <= haystack.length() - needle.length()){

            System.out.println(haystack.substring(indexStart,indexEnd));
            if (Objects.equals(haystack.substring(indexStart,indexEnd),needle)){
                return indexStart;
            }else {
                indexStart++;
                indexEnd = indexStart + needle.length();
            }
        }
        return -1;
    }












    public boolean isPalindrome(String s) {

        int indexStart = 0;
        int indexEnd = s.length() - 1;

        byte[] bytes = s.getBytes();

        while (indexStart < indexEnd){
            byte startByte = bytes[indexStart];
            byte endByte = bytes[indexEnd];

            if (!isAvaild(startByte)){
                indexStart++;
                continue;
            }
            if (!isAvaild(endByte)){
                indexEnd--;
                continue;
            }
            if (!new String(new byte[]{startByte}).equalsIgnoreCase(
                    new String(new byte[]{endByte}))){
                return false;
            }else {
                indexStart++;
                indexEnd--;
            }
        }
        return true;
    }


    public boolean isAvaild(byte aByte){
       return (aByte >= 65 && aByte <=90)
                || (aByte >= 97 && aByte <= 122)
                || ( aByte >= 48 && aByte <= 57);
    }







    public int reverse(int x) {
        boolean flag = x < 0;

        char[] chars = String.valueOf(x).replaceFirst("-","").toCharArray();


        int indexStart = 0;
        int indexEnd = chars.length - 1;

        while (indexStart < indexEnd){
            char temp = chars[indexEnd];
            chars[indexEnd] = chars[indexStart];
            chars[indexStart] = temp;
            indexStart++;
            indexEnd--;
        }

        long parseLong = Long.parseLong(new String(chars));

        if (parseLong > Integer.MAX_VALUE){
            return 0;
        }

        return flag ? 0 - (int)parseLong : (int)parseLong;
    }








    public String replace(String source, String oldChar, String newChar){

        //定义一个窗口
        int indexStart = 0;
        int indexEnd = indexStart + oldChar.length();

        StringBuilder stringBuilder = new StringBuilder();

        if (!Objects.equals(oldChar,newChar)){
            while (indexStart <= source.length() - 1){
                String substring = source.substring(indexStart, indexEnd);
                if (Objects.equals(substring,oldChar)){
                    stringBuilder.append(newChar);
                    indexStart = indexStart + oldChar.length();
                }else {
                    stringBuilder.append(source.charAt(indexStart));
                    indexStart++;
                    indexEnd = indexStart + oldChar.length();
                    indexEnd = indexEnd > source.length() - 1 ? (source.length() - 1) : indexEnd;
                }
            }
            return stringBuilder.toString();
        }
        return source;
    }





    @Test
    public void main1(){
        int[] ints = {-5,-4,1,2,5};
        PrintUtil.printArray(sortedSquares(ints));
    }

    public int[] sortedSquares(int[] A) {


        return A;
    }
}
