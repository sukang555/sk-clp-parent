package com.skse.entity;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable{

	private static final long serialVersionUID = -546093814498174908L;
	
	private String name;
	
	private int age;

	private List<String> names;



	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
