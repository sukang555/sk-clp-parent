package com.skse.se.jvm.thread;


import java.util.concurrent.TimeUnit;

/**
 * Created by sukang on 2018/7/27.
 */


/**
 * threacLocal存放的是变量的引用，如果是多线程共享变量，如果改变值会导致其它线程的值也改变；
 */

class ThreadLocalDemo1 implements Runnable{
    private static  ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private String user;

    public ThreadLocalDemo1(String user) {
        this.user = user;
    }

    @Override
    public void run() {
        threadLocal.set(user);
        String name = Thread.currentThread().getName();
        try {
            if ("AA".equals(name)) {
                ThreadLocalTest.sukang = "hello";
            }else {
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+ threadLocal.get());
    }
}


public class ThreadLocalTest{
    static String  sukang = "sukang";
    public static void main(String[] args) throws Exception{

        //User sukang = new User("sukang", 26);


        ThreadLocalDemo1 localDemo1 = new ThreadLocalDemo1(sukang);


        Thread thread = new Thread(localDemo1, "AA");

        Thread thread1 = new Thread(localDemo1, "BB");

        thread1.start();thread.start();
        thread1.join();thread.join();
        System.out.println(sukang.toString());

    }
}
