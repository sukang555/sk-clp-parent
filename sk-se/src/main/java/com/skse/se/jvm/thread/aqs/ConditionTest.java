package com.skse.se.jvm.thread.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hand on 2018/3/9.
 */
public class ConditionTest {

    final Lock lock = new ReentrantLock();


    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];

    int putptr, takeptr, count;


    //生产

    public void product(Object object) throws InterruptedException{
        lock.lock();

        try {

            while (count == items.length){
                notFull.await();
            }

            items[putptr] = object;

            if (++putptr == items.length){ putptr = 0;}
            ++count;
            notEmpty.signal();

        }finally {
            lock.unlock();
        }

    }




    //消费

    public Object consume() throws  InterruptedException{

        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }// 队列为空，等待，直到队列 not empty，才能继续消费
            Object x = items[takeptr];
            if (++takeptr == items.length) {takeptr = 0;}
            --count;
            notFull.signal(); // 被我消费掉一个，队列 not full 了，发个通知出去
            return x;
        } finally {
            lock.unlock();
        }
    }























































}
