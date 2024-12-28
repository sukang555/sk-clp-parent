package com.skse.computer.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sukang
 */
public class LeetCodeString {


    /**
     *
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     *
     *
     *
     * 示例 1：
     *
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     *
     * 示例 2：
     *
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     *
     * 示例 3：
     *
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     *
     * 示例 4：
     *
     * 输入：S = "a#c", T = "b"
     * 输出：false
     * 解释：S 会变成 “c”，但 T 仍然是 “b”。
     */

    @Test
    public void main12(){
        System.out.println(backspaceCompare("ab##","c#d#"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<String> stackS = new Stack<>();
        Stack<String> stackT = new Stack<>();


        char[] chars = S.toCharArray();

        for (char aChar : chars) {
            if (aChar != '#'){
                stackS.push(String.valueOf(aChar));
            }else{
                if (!stackS.empty()){
                    stackS.pop();
                }
            }
        }


        char[] chars1 = T.toCharArray();

        for (char c : chars1) {
            if (c != '#'){
                stackT.push(String.valueOf(c));
            }else{
                if (!stackT.empty()){
                    stackT.pop();
                }
            }
        }
        return stackS.equals(stackT);
    }
















    @Test
    public void main10(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     *给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

     说明：本题中，我们将空字符串定义为有效的回文串。

     示例 1:

     输入: "A man, a plan, a canal: Panama"
     输出: true

     */

    public boolean isPalindrome(String s) {
        int indexL = 0;
        int indexR = s.length() - 1;
        char[] chars = s.toCharArray();

        while (indexL < indexR){
            if (!Character.isLetterOrDigit(chars[indexL]) || chars[indexL] == ' '){
                indexL++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[indexR]) || chars[indexR] == ' '){
                indexR--;
                continue;
            }

            if (!String.valueOf(chars[indexL]).equalsIgnoreCase(String.valueOf(chars[indexR]))){
                return false;
            }
            indexL++;
            indexR--;
        }
        return true;
    }


    /**
     * 字符串匹配算法
     * BBC ABCDAB ABCDABCDABDE
     *
     * ABCDABD
     */
    @Test
    public void main11(){
        char[] txt = "BBC ABCDAB ABCDABCDABDE".toCharArray();

        List<Integer> result = new ArrayList<>();

        char[] p = "ABCDABD".toCharArray();

        int index = 0;
        int loop = 0;
        while (index <= txt.length - p.length){
            while (loop < p.length){
                if (p[loop] != txt[index + loop]){
                    index++;
                    break;
                }else {
                    loop++;
                }
                if (loop == p.length){
                    result.add(index);
                    index++;
                }
            }
            loop = 0;
        }
        result.forEach(System.out::println);
    }










    /**
     * 最长公共前缀

     编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"

     示例 2:

     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。

     */
    @Test
    public void  main2(){
        String s = longestCommonPrefix(new String[]{"flower", "ow", "flight"});

        System.out.println(s);
    }



    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        String templateStr = strs[0];
        int index = 0;
        while (index < strs.length){

            while (strs[index].indexOf(templateStr) != 0){
                templateStr = templateStr.substring(0,templateStr.length() - 1);
            }
            index++;
        }
        return templateStr;
    }



    /**
     实现strStr() 函数。
     给定一个 haystack 字符串和一个 needle 字符串,
     在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始).
     如果不存在，则返回 -1。

     示例 1:
     输入: haystack = "hello", needle = "ll"
     输出: 2

     示例 2:
     输入: haystack = "aaaaa", needle = "bba"
     输出: -1

     */
    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()){
            return -1;
        }
        if ("".equals(needle)){
            return 0;
        }


        byte[] haystackBytes = haystack.getBytes();
        byte[] needleBytes = needle.getBytes();

        l1:for(int index = 0;index <= haystack.length() - needle.length();++index){

            for (int i = 0; i < needle.length(); i++) {
                if (haystackBytes[index + i] != needleBytes[i]){
                    continue l1;
                }
                if (i == needle.length() - 1){
                    return index;
                }
            }
        }
        return -1;
    }




    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。

         输入为非空字符串且只包含数字 1 和 0。

         示例 1:
         输入: a = "11", b = "1"
         输出: "100"

         示例 2:
         输入: a = "1010", b = "1011"
         输出: "10101"


     0:48  1:49  2:50

     */
    public String addBinary(String a, String b) {

        char[] addNumBytes;
        char[] addNumedBytes;
        if (a.length() >= b.length()){
            addNumBytes = a.toCharArray();
            addNumedBytes = b.toCharArray();
        }else {
            addNumBytes = b.toCharArray();
            addNumedBytes = a.toCharArray();
        }


        int index = 0;
        int buffer = 0;
        while (index < addNumBytes.length){

            int i = addNumBytes.length - index - 1;
            int j = addNumedBytes.length - index - 1;

            char addNumed = j < 0 ? '0' : addNumedBytes[j];

            int sum = Integer.valueOf(String.valueOf(addNumBytes[i]))
                    + Integer.valueOf(String.valueOf(addNumed)) + buffer;

            if (sum == 2){
                addNumBytes[i] = '0';
                buffer = 1;
            }else if (sum == 3){
                addNumBytes[i] = '1';
                buffer = 1;
            }else {
                addNumBytes[i] = String.valueOf(sum).charAt(0);
                buffer = 0;
            }
            ++index;
        }

        return buffer > 0 ? "1".concat(new String(addNumBytes)) : new String(addNumBytes);
    }












    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。
     */
    @Test
    public void main1(){
        String string = "A man, a plan, a canal: Panama";

        byte[] bytes = string.getBytes();


        int i = 0;
        int j = bytes.length - 1;

        while (i < j){
            byte temp = bytes[j];
            bytes[j] = bytes[i];
            bytes[i] = temp;
            i++;
            j--;
        }

        System.out.println(new String(bytes));


    }

}
