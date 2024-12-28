package com.skse.computer.leetcode.hash;

import org.junit.Test;

import java.util.*;

/**
 * @author sukang
 */
public class LeetCodeHash {

    @Test
    public void main1(){

        System.out.println(isIsomorphic("paper","title"));
    }

    /**

     给定两个字符串 s 和 t，判断它们是否是同构的。

     如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

     所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，
     但字符可以映射自己本身。

     示例 1:
     输入: s = "egg", t = "add"
     输出: true

     示例 2:
     输入: s = "foo", t = "bar"
     输出: false

     示例 3:
     输入: s = "paper", t = "title"
     输出: true

     说明:
     你可以假设 s 和 t 具有相同的长度。
     */
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        String template = t;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            Character character = map.putIfAbsent(sChars[i], tChars[i]);
            if (character == null){
                template = template.replace(tChars[i],sChars[i]);
            }
        }
        return s.equals(template);
    }








    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

     示例:
     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]


     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }












    /**
     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     说明：
     你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     
     2次 本身和本身异或为0
     
     */

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;

    }








    public boolean containsDuplicate(int[] nums) {
        Set<Object> hashSet = new HashSet<>();

        for (int num : nums) {
            if (hashSet.contains(num)){
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
}
