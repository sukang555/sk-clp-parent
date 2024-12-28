package com.skse.computer.structure;

import java.util.Comparator;

/**
 * 二叉搜索树
 * @author hand
 *
 */





public class BinarySearchTree<T> {

	/**
		根节点
	 */
	private Node<T> rootNode;
	
	private Comparator<Node<T>> comparable;
	

	public BinarySearchTree(Comparator<Node<T>> comparable) {
		this.comparable = comparable;
	}

	public Node<T> getRootNode() {
		return rootNode;
	}
	
	public void setRootNode(Node<T> rootNode) {
		this.rootNode = rootNode;
	}
	
	public void insertNode(T string){
		Node<T> node = new Node<>(string);
		if (this.rootNode == null ) {
			this.rootNode = node;
		}else {
			Node<T> currentNode = this.rootNode;
			for (;;) {
				int compareTo = comparable.compare(node, currentNode);
				//大于等于走右边
				if ( compareTo > 0) {
					if (currentNode.getRight() == null) {
						currentNode.setRight(node);
						return;
					}else {
						currentNode = currentNode.getRight();
					}
					//小于走左边
				}else if (compareTo < 0){
					if (currentNode.getLeft() == null) {
						currentNode.setLeft(node);
						return;
					}else {
						currentNode = currentNode.getLeft();
					}
				}
			}	
		}	
	}
	
	
	
	public Node<T> getNode(Node<T> node){
		
		Node<T> currentNode = this.rootNode;
		for(;;){
			int compareTo = comparable.compare(node, currentNode);
			if (compareTo == 0) {
				return currentNode;
			}else if (compareTo > 0) {
				currentNode = currentNode.getRight();
			}else if (compareTo < 0) {
				currentNode = currentNode.getLeft();
			}
			
			if (currentNode == null){ return null;}
		}
	}
	

}

class Node<T>{
	private T data;
	private Node<T> left;
	private Node<T> right;


	public Node(T data) {
		super();
		this.data = data;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}


}
