package com.skse.utils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;


public class CollectionUtil {
	
	
	public static void main(String[] args) {
		ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("AA", "AA");
		concurrentHashMap.put("BB", "BB");
		concurrentHashMap.put("CC", "CC");
		concurrentHashMap.put("DD", "DD");
		concurrentHashMap.put("EE", "EE");
	}
	
	@Test
	public void main3(){
		TreeMap<Object, Object> treeMap = new TreeMap<>();
		
		treeMap.put("1", "11");
		treeMap.put("2", "11");
		treeMap.put("3", "11");
		treeMap.put("4", "11");
		
		System.out.println(treeMap.get("2"));
	}
	
	
	@Test
	public void main2(){
		HashMap<Object, Object> hashMap = new LinkedHashMap<>();
		hashMap.put("AA", "");
		hashMap.put("BB", "");
		hashMap.put("CC", "");
		
		Set<Entry<Object, Object>> entrySet = hashMap.entrySet();
		
		entrySet.forEach( t -> System.out.println(t.getKey()));
		
	}


	@Test
	public void main1(){
		Stack<Object> stack = new Stack<>();
		
		//向栈中压入元素
		stack.push("AA");
		stack.push("BB");
		stack.push("CC");
		//peek函数是从查看栈顶元素，但是不删除
		System.out.println(stack.peek());//CC
		//pop函数是移除并获取到栈顶元素
		//search是查找一个元素在Stack中的index
		System.out.println(stack.search("CC"));//1
	}

	@Test
	public void main5(){

		int cap = 14;
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		System.out.println(n + 1);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
