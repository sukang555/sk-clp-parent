package com.skse.se.jvm.thread.lock;

/**
 * Created by sukang on 2018/7/25.
 */

/**
 * synchronized作用于实例方法
 * 我们开启两个线程操作同一个共享资源即变量i，由于i++;操作并不具备原子性,因此会出现线程安全的问题;
 *
 * 当一个线程正在访问一个对象的 synchronized 实例方法，
 * 那么其他线程不能访问该对象的其他 synchronized 方法，
 * 毕竟一个对象只有一把锁，当一个线程获取了该对象的锁之后;
 * 其他线程无法获取该对象的锁，所以无法访问该对象的其他synchronized实例方法，
 * 但是其他线程还是可以访问该实例对象的其他非synchronized方法
 *
 *
 * 原理
 *
 * 方法级的同步是隐式，即无需通过字节码指令来控制的，它实现在方法调用和返回操作之中。
 * JVM可以从方法常量池中的方法表结构(method_info Structure) 中的 ACC_SYNCHRONIZED
 * 访问标志区分一个方法是否同步方法。当方法调用时，调用指令将会 检查方法的 ACC_SYNCHRONIZED
 * 访问标志是否被设置，如果设置了，执行线程将先持有monitor（虚拟机规范中用的是管程一词），
 * 然后再执行方法，最后再方法完成(无论是正常完成还是非正常完成)时释放monitor。
 * 在方法执行期间，执行线程持有了monitor，其他任何线程都无法再获得同一个monitor。
 * 如果一个同步方法执行期间抛 出了异常，并且在方法内部无法处理此异常，
 * 那这个同步方法所持有的monitor将在异常抛到同步方法之外时自动释放
 *
 *
 *
 *
 *
 *
 *
 */
public class SynchronizedTest implements Runnable{

    /**
     * 共享资源
     */
    private int num;

    private synchronized void increSyn(){
        ++num;
    }

    private void incre(){
        ++num;
    }


    @Override
    public void run() {
        for (int i = 0;i < 1000000;i++){
            incre();
        }
    }


    public static void main(String[] args) throws Exception{

        SynchronizedTest instance = new SynchronizedTest();
        Thread a = new Thread(instance,"AA");
        Thread b = new Thread(instance,"BB");
        a.start();b.start();
        a.join();b.join();
        System.out.println(instance.num);

    }
}
