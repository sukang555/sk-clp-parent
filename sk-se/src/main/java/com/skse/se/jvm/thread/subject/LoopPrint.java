package com.skse.se.jvm.thread.subject;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sukang on 2019/11/21 16:00
 */
public class LoopPrint {

    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    private int sum = 100;



    @Test
    public void main1 () throws Exception{

        Thread a = new Thread( () -> {
            try {
                while (atomicInteger.get() < sum){
                    semaphoreA.acquire();
                    System.out.println(Thread.currentThread().getName() + "::" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                    semaphoreB.release(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A");


        Thread b = new Thread( () -> {
            try {
                while (atomicInteger.get() <= sum) {
                    semaphoreB.acquire();
                    System.out.println(Thread.currentThread().getName() + "::" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                    semaphoreA.release(1);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B");


        a.start();
        b.start();
        a.join();
        b.join();

    }



}
