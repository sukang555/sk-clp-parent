package com.skse.se.jvm.thread;


/**
 * @Author: sukang
 * @Date: 2021/11/10 21:01
 */
public class Demo {

    private final static Object LOCK = new Object();

    private  static int NUMS = 10;

    private static volatile Boolean printFlag=  Boolean.TRUE;


    public static void main(String[] args) {


        Thread threadA = new Thread(() -> {

            for (int i = 0; i < NUMS; i++) {
                synchronized (LOCK) {

                    if (!printFlag){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    System.out.println(Thread.currentThread().getName() +  ":::" + "A");
                    printFlag = Boolean.FALSE;
                    LOCK.notify();
                }
            }

        }, "A");


        Thread threadB = new Thread(() -> {
            for (int i = 0; i < NUMS; i++) {
                synchronized (LOCK) {
                    if (printFlag){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println(Thread.currentThread().getName() +  ":::" +"B");
                    printFlag = Boolean.TRUE;
                    LOCK.notify();
                }
            }

        }, "B");

        threadB.start();
        threadA.start();

    }
}
