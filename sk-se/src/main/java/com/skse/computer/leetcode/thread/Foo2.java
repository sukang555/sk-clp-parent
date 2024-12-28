package com.skse.computer.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @author sukang on 2019/7/30.
 */
public class Foo2 {

    private Semaphore semaphoreA = new Semaphore(1);

    private Semaphore semaphoreB = new Semaphore(0);

    private Semaphore semaphoreC = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        semaphoreA.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphoreB.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphoreB.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphoreC.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphoreC.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
