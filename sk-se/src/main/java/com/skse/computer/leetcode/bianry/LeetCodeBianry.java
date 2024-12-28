package com.skse.computer.leetcode.bianry;

import org.junit.Test;

/**
 * @author sukang
 */
public class LeetCodeBianry {


    @Test
    public void main1(){
        int search = search(new int[]{-1,0,3,5,9,12}, 2);

        System.out.println(search);
    }


    /**[-1,0,3,5,9,12]
     2
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
       解释: 9 出现在 nums 中并且下标为 4
     */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int middle = left + (right - left)/2;

            if (nums[middle] < target){
                left = middle + 1;
            }else if (nums[middle] > target){
                right = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;

    }


}
