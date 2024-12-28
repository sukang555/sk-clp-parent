package com.skse.computer.algorithm;


import org.junit.Test;

public class HanNuo {
	
	private int i  = 1;
	
	@Test
	public void main1(){
		hannuota(10, "A", "B", "C");
	}
	
	         
	void move(int panzi,String form,String to){
		System.out.printf("第%d步将%d号盘子从%s移动到%s\n",i++,panzi,form,to);
	}
	
	public void hannuota(int n,String start,String trans,String end){
		
		if (n == 1) {
			move(n, start, end);
		}else {
			//递归处理,一开始的时候,先将n-1个盘子从a移至过渡柱上b
			hannuota(n-1,start ,end ,trans );
			//然后再将底下的大盘子直接移至目标柱子即可  
			move(n,start ,end );
			//递归处理  再将 n-1个盘子从 b移到a上
			hannuota(n-1,trans ,start ,end );
		}
	}
	
	
	public Integer getSum(int num){
		
		if (num == 1) {
			return 1;
		}else {
			return num += getSum(--num) ;
		}
	}
	
	
	
	public boolean is(int num){
		return (num & (num -1)) == 0;
	}

}
