package com.skse.se.design.behavioral.Templat;


/**
 * 模板设计模式
 */ 
public abstract class Templat {
	
	public abstract void doPost(String string);
	
	
	public void service (String string){
		doPost(string);
	}

}
