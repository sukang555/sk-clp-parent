
package com;


import org.junit.Test;

/**
 * @author sukang on 2019/2/18.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class LeetCodeTest {

    @Test
    public void main1(){
       integerReplacement(65535);
    }


    public int integerReplacement(int n) {

        int j = 0;
        int i = n;

        while(i != 1){
            if(i % 2 == 0){
                i = i / 2;
            }else{
                i = (i + 1)/2 > (i - 1) / 2 ?  i - 1 : i + 1;
            }
            j++;

            System.out.println(i);
        }

        System.out.println(j);
        return j;
    }




    /**
     * [-4,-1,0,3,10]
     */
    public int[] sortedSquares(int[] a) {
        int index1 = 0;
        int index2 = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0){
                index2 = i;
                break;
            }
        }
        int[] result = new int[a.length];



        return result;
    }






    /**
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode index1 = head;
        ListNode index2 = head;

        for (int i = 1; i <= n; i++) {
            index1 = index1.next;
        }

        if (index1 == null){
            return head.next;
        }

        while (index1.next != null){
            index2 = index2.next;
            index1 = index1.next;
        }

        ListNode next = index2.next.next;
        index2.next = next;

        return head;
    }




    //[-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}

