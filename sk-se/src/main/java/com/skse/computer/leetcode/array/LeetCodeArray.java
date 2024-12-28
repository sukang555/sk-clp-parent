package com.skse.computer.leetcode.array;

import org.junit.Test;
import com.skse.utils.PrintUtil;

import java.util.*;

/**
 * @author sukang
 */
public class LeetCodeArray {

    private volatile String s = "sukang";


    @Test
    public void main9(){
        int[] ints = new int[]{0,1,0,0,0};
        System.out.println(dominantIndex(ints));

    }


    /**
     * 求众数
     * [2,2,2,3,3,3,3,5]
     */
    public int majorityElement(int[] nums) {
        for (int num : nums) {


        }
        return 0;
    }








    /**
         在一个给定的数组nums中，总是存在一个最大元素 。
         查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
         如果是，则返回最大元素的索引，否则返回-1。

         示例 1:
         输入: nums = [3, 6, 1, 0]
         输出: 1
         解释: 6是最大的整数, 对于数组中的其他整数,
         6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.

         示例 2:
         输入: nums = [1, 2, 3, 4]
         输出: -1
         解释: 4没有超过3的两倍大, 所以我们返回 -1.
     */

    public int dominantIndex(int[] nums) {
        
        if (nums.length <= 1){
            return 0;
        }


        return 1;
    }







    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
     *       1
     *       1 1
     *       1 2 1
     *       1 3 3 1
     */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> range = new ArrayList<>();
        range.add(new ArrayList<>());
        if (numRows == 0){
            return range;
        }
        range.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            range.add(i,new ArrayList<>());
            //第一个
            range.get(i).add(0,1);

            for (int j = 1; j < i; j++) {
                range.get(i).add(j,range.get(i - 1).get(j - 1)
                        +range.get(i - 1).get(j));
            }

            //最后一个
            range.get(i).add(i,1);
        }
        return range;
    }



    /**
         给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
         返回移除后数组的新长度。

         不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

         示例 1:
         给定数组 nums = [1,1,2],

     121

         函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

         你不需要考虑数组中超出新长度后面的元素。

         示例 2:
         给定 nums = [0,0,1,1,1,2,2,3,3,4],
                      0,1,0,1,1,2,2,3,3,4
         函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

         你不需要考虑数组中超出新长度后面的元素。
     */

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1){
            return nums.length;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index + 1];
                nums[index + 1] = temp;
                ++index;
            }
        }
        return index +1 ;
    }











    /**
     * 输入: "Let's take LeetCode contest"
     输出: "s'teL ekat edoCteeL tsetnoc"


     注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

     */

    public String reverseWords2(String s) {
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = bytes.length - 1;

        while (i < j) {
            byte temp = bytes[j];
            bytes[j] = bytes[i];
            bytes[i] = temp;
            i++;
            j--;
        }

        String[] split = new String(bytes).split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = split.length - 1; k >= 0; k--) {
            stringBuilder.append(split[k]);
            if (k != 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。

     示例:
     输入: "the sky is blue",
     输出: "blue is sky the".


     说明:
     •无空格字符构成一个单词。
     •输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     •如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

     */
    public String reverseWords(String s) {

        int begin = 0,end = 0;
        Vector<String> vector = new Vector<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' '){
                begin = i;
            }
            if (chars[i] == ' ' && begin > 0){
                end = i;
                vector.add(new String(chars,i,end));
                begin = 0;end = 0;
            }
        }

        vector.forEach(System.out::println);
        return "";

    }





    /**
     *   给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
         示例 1:
         输入: [1,2,3,4,5,6,7] 和 k = 3
         输出: [5,6,7,1,2,3,4]
         解释:
         向右旋转 1 步: [7,1,2,3,4,5,6]
         向右旋转 2 步: [6,7,1,2,3,4,5]
         向右旋转 3 步: [5,6,7,1,2,3,4]
     */

    @Test
    public void main8(){
        int  k = 3;
        int[] nums = new int[]{1};

        


        PrintUtil.printArray(nums);




    }



    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

     示例:
     输入: [0,1,0,3,12]
     输出: [1,3,12,0,0]

     说明:
     1.必须在原数组上操作，不能拷贝额外的数组。
     2.尽量减少操作次数。

     */
    @Test
    public void main7(){
        int[] nums = new int[]{0,0,3,6,0};

        for (int i = 0; i < nums.length; i++) {
           if (nums[i] == 0){
              for (int j = i+1; j < nums.length; j++) {
                   if (nums[j] != 0){
                       int temp = nums[i];
                       nums[i] = nums[j];
                       nums[j] = temp;
                       break;
                   }
               }
           }
        }

        PrintUtil.printArray(nums);

    }








    /**
     *
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

     函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

     说明:
     •返回的下标值（index1 和 index2）不是从零开始的。
     •你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

     示例:
     输入: numbers = [2, 7, 11, 15], target = 9
     输出: [1,2]
     解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

     *
     *
     */

    @Test
    public void main6(){
        int[] nums = new int[]{0, 0, 0, 0};
        int[] result = new int[2];

        if (nums[nums.length - 1] + nums[nums.length -2] <9){

        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i ; j--) {
                if (nums[i]+ nums[j] == 9){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        Arrays.stream(result).forEach(
                t -> System.out.println(t)
        );

    }

    /**
     *
     * 给定一个二进制数组， 计算其中最大连续1的个数。

     示例 1:
     输入: [1,1,0,1,1,1]
     输出: 3
     解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.

     */

    @Test
    public void main5(){
        int[] nums = new int[]{0,1,0,0,1,1,1,0,1};
        int max = 0;
        int temp = 0;
        for (int num : nums) {
            if (num == 1){
                temp++;
            }else {
                temp = 0;
            }
            max = Math.max(max,temp);
        }
        System.out.println(max);

    }


    @Test
    public void main4(){
        int val = 3;
        int[] array = new int[]{2};
        int len = array.length;

        l2: for (int i = 0; i < array.length; i++) {

            if (val == array[i]){
                l1:  for (int j = array.length - 1; j >= i; j--) {
                    if (i == j){
                        len = i;
                        break l2;
                    }
                    if (val != array[j]){
                        int temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                        break l1;
                    }
                }
                --len;
            }
        }

        System.out.println(len);

    }















    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

     最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。

     示例 1:
     输入: [1,2,3]
     输出: [1,2,4]
     解释: 输入数组表示数字 123。


     */
    @Test
    public void main2(){

        int[] array = new int[]{6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};

        int length = array.length;

        for (int i = length - 1; i >= 0 ; i--) {
            if (array[i] < 9){
                array[i]++;
                break;
            }
            array[i] = 0;
        }

        int[] newArray = new int[length +1];
        newArray[0] = 1;
        Arrays.stream(newArray).forEach(
                t -> System.out.println(t)
        );

    }


    /**
     *
     给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     示例 1:
     输入:
     nums = [, 7, 3, 6, 5, 6]
     输出: 3
     解释:
     索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
     同时, 3 也是第一个符合要求的中心索引。
     *
     */
    public static int main1(){
        int[] nums = new int[]{-1,-1,-1,0,1,1};

        int sum = getSum(nums,nums.length - 1);
        int beginSum = 0, endSum = sum;

        for (int pointIndex = 0,len = nums.length; pointIndex < len; pointIndex++) {

            if (pointIndex > 0){
                beginSum += nums[pointIndex - 1];
            }
            if (pointIndex < len){
                endSum -= nums[pointIndex];
            }


            if (beginSum < endSum){
                continue;
            }
            if (beginSum == endSum){
                return pointIndex;
            }
        }
        return -1;
    }



    private static int getSum(int[] nums,int index) {
        if (index == 0){
            return nums[index];
        }
        return nums[index] + getSum(nums,--index);
    }
}
