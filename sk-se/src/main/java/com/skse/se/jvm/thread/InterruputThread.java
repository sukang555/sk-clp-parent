package com.skse.se.jvm.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by sukang on 2018/7/25.
 *
 *
 *
 * 处于运行期且非阻塞的状态的线程，这种情况下，
 * 直接调用Thread.interrupt()中断线程是不会得到任响应的
 *
 * 虽然我们调用了interrupt方法，但线程t1并未被中断，
 * 因为处于非阻塞状态的线程需要我们手动进行中断检测并结束程序
 *
 * 我们在代码中使用了实例方法isInterrupted判断线程是否已被中断，如果被中断将跳出循环以此结束线程,
 * 注意非阻塞状态调用interrupt()并不会导致中断状态重置。综合所述，可以简单总结一下中断两种情况，
 * 一种是当线程处于阻塞状态或者试图执行一个阻塞操作时，我们可以使用实例方法interrupt()进行线程中断，
 * 执行中断操作后将会抛出interruptException异常(该异常必须捕捉无法向外抛出)并将中断状态复位，
 * 另外一种是当线程处于运行状态时，我们也可调用实例方法interrupt()进行线程中断，但同时必须手动判断中断状态，
 * 并编写中断线程的代码(其实就是结束run方法体的代码)。
 *
 *
 *
 *
 *事实上线程的中断操作对于正在等待获取的锁对象的synchronized方法或者代码块并不起作用，
 * 也就是对于synchronized来说，如果一个线程在等待锁，那么结果只有两种，
 * 要么它获得这把锁继续执行，要么它就保存等待，即使调用中断线程的方法，也不会生效
 *
 *
 *
 * 需要特别理解的一点是，与sleep方法不同的是wait方法调用完成后，线程将被暂停，
 * 但wait方法将会释放当前持有的监视器锁(monitor),
 * 直到有线程调用notify(不固定取决于线程调度器)/notifyAll(所有)方法后方能继续执行，而sleep方法只让线程休眠并不释放锁。
 * 同时notify/notifyAll方法调用后，并不会马上释放监视器锁，
 * 而是在相应的synchronized(){}/synchronized方法执行结束后才自动释放锁
 *
 *
 *
 */
public class InterruputThread implements Runnable{

    @Override
    public void run() {
        while (true){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("被打断");
                break;
            }else {
                System.out.println("未被中断");
            }
        }
    }


    public static void main(String[] args){
        Thread thread = new Thread(new InterruputThread());

        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
            thread.interrupt();
            System.out.println(thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
