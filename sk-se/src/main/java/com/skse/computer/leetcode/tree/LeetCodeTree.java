package com.skse.computer.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *@author sukang  on 2019/1/11.
 */
public class LeetCodeTree {

    private static int length = 0;
    private static int loop = 0;


    @Test
    public void main1(){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;
        treeNode2.left =treeNode3;


        List<Integer> integers = preorderTraversal(treeNode1);

        System.out.println(maxDepth(treeNode1));
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        if (root.left != null && root.left.val <= root.val){
            isValidBST(root.left);
        }

        if (root.right != null && root.right.val >= root.val){
            isValidBST(root.right);
        }
        return false;
    }


    /**
     * 给定一个二叉树，找出其最大深度。

     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

     说明: 叶子节点是指没有子节点的节点。
     */

    public int maxDepth(TreeNode root) {
        d(root);
        return length;
    }



    public void d(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        loop++;
        length = Math.max(length,loop);
        d(treeNode.left);
        loop = 0;
        d(treeNode.right);
    }





    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> objects = new ArrayList<>();
        if (root == null){
            return objects;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }

            objects.add(list);
        }
        return objects;
    }




    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        f(root,list);
        return list;
    }


    /**
     * 中序遍历
     */
    public void f(TreeNode treeNode, List<Integer> list){
        if (treeNode == null ){
            return;
        }
        f(treeNode.left,list);
        list.add(treeNode.val);
        f(treeNode.right,list);
    }


    /**
     * 前序遍历
     */
   /* public void f(TreeNode treeNode,List<Integer> list){
        if (treeNode == null){
           return;
        }
        list.add(treeNode.val);
        f(treeNode.left,list);
        f(treeNode.right,list);
    }*/
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}