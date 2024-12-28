package com.skse.computer.leetcode.thread;


import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author sukang on 2019/7/26.
 *
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 *     线程 A 将调用 zero()，它只输出 0 。
 *     线程 B 将调用 even()，它只输出偶数。
 *     线程 C 将调用 odd()，它只输出奇数。
 *     n = 6
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列
 *
 *
 * 010203040506... ，其中序列的长度必须为 2n.
 */
class ZeroEvenOdd {
    private int n;

    private Semaphore s1,s2,s3;

    public ZeroEvenOdd(int n) {
        this.n = n;
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i++) {
            s1.acquire();
            printNumber.accept(0);

            if (isEvent(i)){
                //偶数
                s2.release();
            }else {
                //奇数
                s3.release();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n ; i+=2) {
            s2.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i+=2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }

    private boolean isEvent(int num){
        return (num & 1) == 0;
    }
}
