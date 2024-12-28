package com.skse.se.jvm.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class AQS {
	
	
	private static final ReentrantLock reentrantLock = new ReentrantLock(true);
	
	
	
	
	public static void main(String[] args) {

		LockSupport.park();
		
		
		//new Thread(() -> {work();},"T1").start();
		
		//new Thread(() -> {work();},"T2").start();
		
	}
	
	
	
	public static void work(){
		reentrantLock.lock();
		
		try {
			
			Thread currentThread = Thread.currentThread();
			System.out.println(currentThread.getName() +"执行任务");
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			reentrantLock.unlock();
		}
	}
	
	
	
     
     
	
			

}
