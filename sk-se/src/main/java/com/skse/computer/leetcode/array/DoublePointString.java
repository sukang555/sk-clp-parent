package com.skse.computer.leetcode.array;

import org.junit.Test;

/**
 * @author sukang  sukang on 2019/1/8.
 */
public class DoublePointString {

    @Test
    public void main1() {
        int[] array = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,array));
    }


    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

     示例:

     输入: s = 7, nums = [2,3,1,2,4,3]
     输出: 2
     解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

     */



    public int minSubArrayLen(int s, int[] nums) {

        int res = nums.length + 1;
        int sum = 0;
        int index1 = 0;
        int index2 = -1;

        while (index1 < nums.length){

            if (index2 < nums.length -1 && sum < s){
                index2++;
                sum += nums[index2];
            }else {
                sum -= nums[index1];
                index1++;
            }

            if (sum == s){
                res = Math.min(res,index2 - index1 +1);
            }
        }

        return res == nums.length + 1 ? 0 : res;
    }










    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     *
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */
    public boolean isPalindrome(int  x) {

        int head = 0;
        int tail = String.valueOf(x).length() - 1;
        char[] sBytes = String.valueOf(x).toCharArray();
        while (head < tail){

            if (String.valueOf(sBytes[head])
                    .equalsIgnoreCase(String.valueOf(sBytes[tail]))){
                head++;
                tail --;
            }else {
                return false;
            }
        }
        return true;
    }

}
