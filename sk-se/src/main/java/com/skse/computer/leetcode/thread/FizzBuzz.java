package com.skse.computer.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * <p>
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz,
 * buzz, 11, fizz, 13, 14, fizzbuzz
 *
 * @author sukang on 2019/10/11 9:57
 */
public class FizzBuzz {
    private int n;

    private volatile int atomicInteger = 1;
    
    private ReentrantLock reentrantLock = new ReentrantLock();
    private  Condition condition = reentrantLock.newCondition();



    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {

        while (atomicInteger <= n) {
            condition.await();
            if ((atomicInteger % 3 == 0) && (atomicInteger % 5 != 0)) {
                printFizz.run();
                ++atomicInteger;
            }
            condition.signalAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (atomicInteger <= n) {
            if ((atomicInteger % 5 == 0) && (atomicInteger % 3 != 0)) {
                printBuzz.run();
                ++atomicInteger;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        while (atomicInteger <= n) {
            if (atomicInteger % 15 == 0) {
                printFizzBuzz.run();
                ++atomicInteger;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (atomicInteger <= n) {
            if ((atomicInteger % 3 != 0) && (atomicInteger % 5 != 0)) {
                printNumber.accept(atomicInteger);
                ++atomicInteger;
            }
        }
    }


}
