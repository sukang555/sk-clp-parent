package com.skse.computer.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author: sukang
 * @Date: 2021/3/31 11:13
 */
public class Print {

    private static Integer nums = 10;

    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);


    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < nums; i++) {
                try {
                    semaphoreA.acquire();
                    int order = i + 1;
                    System.out.print((order) + ":A");
                    semaphoreB.release(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "A");

        Thread b = new Thread(() -> {
            for (int i = 0; i < nums; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.print("B");
                    semaphoreC.release(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");


        Thread c = new Thread(() -> {
            for (int i = 0; i < nums; i++) {
                try {
                    semaphoreC.acquire();
                    System.out.print("C");
                    System.out.println();
                    semaphoreA.release(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C");


        a.start();
        b.start();
        c.start();


    }
}
