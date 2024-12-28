package com.skse.computer.structure;



import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

class TreeNode<T>{
    private TreeNode parent;

    private List<TreeNode<T>> children = Lists.newArrayList();

    private Integer status = 3;

    private String msg;

    private T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(TreeNode parent, T data) {
        this.parent = parent;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
}


/**
 * @author sukang on 2019/4/3.
 */
public class Btree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(null);
        root.setStatus(1);

        TreeNode<Integer> one = new TreeNode<>(1);
        TreeNode<Integer> two = new TreeNode<>(2);
        TreeNode<Integer> three = new TreeNode<>(3);
        TreeNode<Integer> four = new TreeNode<>(4);
        TreeNode<Integer> five = new TreeNode<>(5);
        TreeNode<Integer> six = new TreeNode<>(6);
        TreeNode<Integer> seven = new TreeNode<>(7);
        TreeNode<Integer> eight = new TreeNode<>(8);
        TreeNode<Integer> nine = new TreeNode<>(9);


        root.getChildren().addAll(Arrays.asList(one,two,three,four));
        one.setParent(root);
        two.setParent(root);
        three.setParent(root);
        four.setParent(root);


        one.getChildren().addAll(Arrays.asList(five,six));
        five.setParent(one);
        six.setParent(one);



        five.setChildren(Arrays.asList(seven, eight));
        seven.setParent(five);
        eight.setParent(five);


        nine.setParent(three);
        three.getChildren().add(nine);

        //3 没走   1 true   2 false
        f(root);

        foreach(root);

    }


    private static void foreach(TreeNode<Integer> root){
        List<TreeNode<Integer>> children = root.getChildren();

        if (CollectionUtils.isNotEmpty(children)) {
            for (TreeNode<Integer> child : children) {
                System.out.println(child.getData()+ "::"+ child.getStatus());
                foreach(child);
            }
        }

    }




    private static void f(TreeNode<Integer> root){
        List<TreeNode<Integer>> children = root.getChildren();

        if (CollectionUtils.isNotEmpty(children)){
            for (TreeNode<Integer> child : children) {
                if (Objects.equals(1,child.getParent().getStatus())
                        || child.getParent().getData() == null){
                    if (js(child)){
                        child.setStatus(1);
                        f(child);
                    }else {
                        child.setStatus(2);
                    }
                }
            }
        }
    }


    private static Boolean js(TreeNode treeNode){

        return  Objects.equals(1,treeNode.getData())
                || Objects.equals(6,treeNode.getData());
    }





}
