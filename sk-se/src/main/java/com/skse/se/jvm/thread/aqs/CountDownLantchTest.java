package com.skse.se.jvm.thread.aqs;

import java.util.concurrent.*;

import org.junit.Test;

public class CountDownLantchTest {
	
	@Test
	public void main() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
		
		
		System.out.println("开始等待");
		for (int j = 0; j < 10; j++) {
			fixedThreadPool.submit(new WorkRunnable(countDownLatch, j));
		}
		countDownLatch.await();
		System.out.println("结束等待");
	}
	
	
	
	
	
	@Test
	public void main2() throws  Exception{
		
		CountDownLatch startCountDownLatch = new CountDownLatch(1);
		
		CountDownLatch endCountDownLatch = new CountDownLatch(10);
		
		
		for (int i = 0; i < 10; i++) {
			new Thread(new WorkRunnable2(startCountDownLatch,endCountDownLatch,i),String.valueOf(i))
				.start();
		}


		//由于start的初始值为1，因此调用一次就可以放行

		startCountDownLatch.countDown();


		//所有任务执行完之前进行阻塞
		endCountDownLatch.await();

		System.out.print("所有任务都执行完毕");

		
	}



	class WorkRunnable2 implements Runnable{

		private CountDownLatch start;

		private CountDownLatch end;

		private int second;

		public WorkRunnable2(CountDownLatch start, CountDownLatch end,int second) {
			this.start = start;
			this.end = end;
			this.second = second;
		}

		@Override
		public void run() {

			try{

				//所有线程一起阻塞，等待start开始countDown放行
				start.await();

				doWork(Thread.currentThread());
				TimeUnit.SECONDS.sleep(second);
				//每执行一次
				end.countDown();

			}catch (Exception e){
				e.printStackTrace();
			}

		}


		public void doWork(Thread thread){
			System.out.println(thread.getName()+"执行任务");
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	class WorkRunnable implements Runnable{
		
		private  CountDownLatch countDownLatch;
		
		private int i;
		
		

		public WorkRunnable(CountDownLatch countDownLatch, int i) {
			super();
			this.countDownLatch = countDownLatch;
			this.i = i;
		}



		@Override
		public void run() {
			
			try {
				doWork(i,Thread.currentThread());
				countDownLatch.countDown();
				TimeUnit.SECONDS.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void doWork(int i, Thread thread){
			System.out.println(thread.getName()+"执行任务"+i);
		}
		
	}



	public static void  main(String[] args){
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
        	try {
        		TimeUnit.SECONDS.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	latch.countDown();
        },"T1").start();
        

        new Thread(() -> {
            try {
            	TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
            // 休息 10 秒后(模拟线程工作了 10 秒)，调用 countDown()
            latch.countDown();
            
        }, "T2").start();



        new Thread(() -> {
	        try {
	            // 阻塞，等待 state 减为 0
	            latch.await();
	            System.out.println("线程 t3 从 await 中返回了");
	        } catch (InterruptedException e) {
	            System.out.println("线程 t3 await 被中断");
	            Thread.currentThread().interrupt();
	            e.printStackTrace();
	        }
	        
        }, "T3").start();
        
        
        new Thread(() -> {
            try {
                // 阻塞，等待 state 减为 0
                latch.await();
                System.out.println("线程 t4 从 await 中返回了");
            } catch (InterruptedException e) {
                System.out.println("线程 t4 await 被中断");
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            
        }, "T4").start();

    }

























	

}
