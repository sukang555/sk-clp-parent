package com.skse.computer.leetcode.link;


import org.junit.Test;

/**
 * @author sukang
 * @param <T> 泛型
 * 链表反转算法
 */

class Node<T> {
    private Node next;
    private T data;


    boolean hashNext(){
        return this.getNext() != null;
    }


    Node(T data) {
        this.data = data;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    T getData() {
        return data;
    }
}

/**
 * @author sukang
 */
public class LinkTrans {


    @Test
    public void main1() {
        Node<String> node1 = new Node<>("1");
        Node<String> node2 = new Node<>("2");
        Node<String> node3 = new Node<>("3");
        Node<String> node4 = new Node<>("4");
        node1.setNext(node2);node2.setNext(node3);node3.setNext(node4);

        print(node1);

        Node index = node1;
        Node pre = null;
        Node next = null;


        while (index.hashNext()){

            next = index.getNext();

            index.setNext(pre);


            pre = index;
            index = next;
        }
        index.setNext(pre);
        print(index);

    }













    /**
     * Node next;
     *         Node pre = null;
     *         Node indexNode = node1;
     *
     *         while (indexNode != null){
     *             next = indexNode.getNext();
     *
     *             indexNode.setNext(pre);
     *
     *             pre = indexNode;
     *             indexNode = next;
     *         }
     *
     * @param head
     */
    private static void print(Node head){
        Node current = head;
        do {

            if (current != null){
                if (current.getNext() != null){
                    System.out.print(current.getData()+"-->");
                }else {
                    System.out.print(current.getData());
                }
                current = current.getNext();
            }
        }while (current != null);

        System.out.println();
    }



}
