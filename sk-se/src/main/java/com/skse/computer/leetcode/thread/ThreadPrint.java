package com.skse.computer.leetcode.thread;


import javax.sound.midi.Soundbank;
import java.util.Objects;

/**
 * @Author: sukang
 * @Date: 2021/11/9 13:37
 */
public class ThreadPrint {

    private static final Object object = new Object();

    private static volatile Boolean printFlag = Boolean.TRUE;

    public static void prinAb(String method) throws InterruptedException {

        if (Objects.equals("A",method)){
            synchronized (object){
                if (printFlag){
                    System.out.println(method);
                    printFlag = Boolean.FALSE;
                    object.notifyAll();
                }else {
                    object.wait();
                }
            }
        }

        if (Objects.equals("B",method)){
            synchronized (object){
                if (!printFlag){
                    System.out.println(method);
                    printFlag = Boolean.TRUE;
                    object.notifyAll();
                }else {
                    object.wait();
                }

            }
        }

    }


    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    prinAb("A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A");

        Thread b = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    prinAb("B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        a.start();
        b.start();

    }
}
