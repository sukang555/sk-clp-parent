package com.skse.computer.leetcode.link;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author sukang
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class LeetCodeLink {





    @Test
    public void main3(){
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(4);
        ListNode ListNode3 = new ListNode(4);
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;

        ListNode ListNode5 = new ListNode(5);
        ListNode ListNode6 = new ListNode(6);
        ListNode ListNode4= new ListNode(9);
        ListNode5.next = ListNode6;
        ListNode6.next = ListNode4;

        printLink(addTwoNumbers(ListNode1,ListNode5));

    }


    /**
     给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     示例：
     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode index1 = l1;
        ListNode index2 = l2;
        ListNode newhead = null;
        ListNode pointIndex = null;
        int i = 0;

        while (index1 != null && index2 != null){

            ListNode temp = new ListNode((index1.val + index2.val + i) % 10);
            i = (index1.val + index2.val) >= 10 ? (index1.val + index2.val)/10 : 0;

            if (newhead == null){
                pointIndex = newhead = temp;
            }else {
                pointIndex.next = temp;
                pointIndex = pointIndex.next;
            }

            index1 = index1.next;
            index2 = index2.next;
        }
        return newhead;
    }






    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
       说明：不允许修改给定的链表。
     */
    //@TODO
    public ListNode detectCycle(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode indexNode = head.next;

        while (indexNode != null){
            if (indexNode == head){
                return indexNode;
            }
            indexNode = indexNode.next;
        }
        return null;
    }



    private boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }
        return false;
    }




    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode first = head;

        while (n-- != 0){
            first = first.next;
        }
        if (first == null){return head.next;}

        ListNode target = head;

        while (first.next != null){
            first = first.next;
            target = target.next;
        }

        //移除target的下一个
        ListNode next = target.next.next;
        target.next = next;
        return head;
    }




    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode index = head;
        while (index != null){
            list.add(index.val);
            index = index.next;
        }
        int i = 0;
        int j = list.size() - 1;

        while (i < j){
            if (!Objects.equals(list.get(i),list.get(j))){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }


    //@todo
    /*public ListNode oddEvenList(ListNode head) {

        ListNode listNode1 = head;
        ListNode listNode2;
        int i = 1;

        while (head != null && head.next != null){
            //偶数

        }

        return listNode1;
    }*/


    private static void printLink(ListNode head) {
        ListNode current = head;
        do {

            if (current != null){
                if (current.next != null){
                    System.out.print(current.val+"-->");
                }else {
                    System.out.print(current.val);
                }
                current = current.next;
            }
        }while (current != null);

        System.out.println();
    }




    public ListNode removeElements(ListNode head, int val) {


        ListNode tempHead = new ListNode(val + 1);
        tempHead.next = head;

        ListNode index = head;
        ListNode pre = tempHead;
        while (index != null){

            if (index.val == val){
                pre.next = index.next;
            }else {
                pre = index;
            }
            index = index.next;
        }
        return tempHead.next;
    }




    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;

        }

        return pre;

    }
    
    

}
