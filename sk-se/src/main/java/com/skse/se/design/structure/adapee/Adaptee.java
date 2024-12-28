package com.skse.se.design.structure.adapee;


/**
 * 适配器模式
 * @author admin
 *
 */

interface Target {
	
	public void run();
	
	public void fly();

}

public class Adaptee extends Adapteer implements Target {
	
	@Override
	public void run() {
		
		System.out.println("run");
	}
	
}


class Adapteer{
	
	public void fly(){
		System.out.println("fly");
	}
}
