package com.skse.computer.algorithm;

import org.junit.Test;


public class Step {
	
	protected int num = 10;
	// 楼梯有n阶台阶，上楼可以一步上1阶，也可以一步上2阶，编一程序计算共有多少种不同的走法.
	//设n阶台阶的走法数为f(n)
	@Test
	public void main(){
		/*int[] array = new int[num];
		
		for (int i = 0; i < num; i++) {
			if (i > 2) {
				array[i] = array[i-1] + array[i-2] ;
			}else {
				array[i] = i+1;
			}
			System.out.print(array[i]+",");
		}*/
		
		for (int i = 0; i < 10; i++) {
			System.out.print(feibo(i+1)+",");
		}
	
	}
	
	
	
	private int feibo(int num){
		if (num == 1) return 1;
		if (num == 2) return 2;
		else {
			return feibo(num - 1) + feibo(num -2);
		}
	}
	
	
	
	
	/*
	public int getStep(int num){

	
	private void walk(int i){
		System.out.print(i+",");
	}
	
	
	private int getStep(int num){
		
		walk(num);
		if (num == 1) {
			return 1;
		}else {
			return ;
		}
		if (num == 2) {
			return 2;
		}else if (num < 0) {
			return 0;
		}else {
			return getStep(num-1)+getStep(num - 2);
		}
		
	}*/

}
