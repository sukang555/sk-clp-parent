package com.skse.se.jvm.thread.lock;

/**
 * Created by sukang on 2018/7/25.
 */

/**
 * 原理
 *
 * 每个对象都存在着一个 monitor 与之关联，对象与其 monitor 之间的关系有存在多种实现方式，
 * 如monitor可以与对象一起创建销毁或当线程试图获取对象锁时自动生成，
 * 但当一个 monitor 被某个线程持有后，它便处于锁定状态。在Java虚拟机(HotSpot)中，
 * monitor是由ObjectMonitor实现的
 *
 *
 *
 * ObjectMonitor中有两个队列，_WaitSet 和 _EntryList，
 * 用来保存ObjectWaiter对象列表( 每个等待锁的线程都会被封装成ObjectWaiter对象)，
 * _owner指向持有ObjectMonitor对象的线程，当多个线程同时访问一段同步代码时，
 * 首先会进入 _EntryList 集合，当线程获取到对象的monitor 后进入
 * _Owner 区域并把monitor中的owner变量设置为当前线程同时monitor中的计数器count加1，
 * 若线程调用 wait() 方法，将释放当前持有的monitor，owner变量恢复为null，count自减1，
 * 同时该线程进入 WaitSe t集合中等待被唤醒。若当前线程执行完毕也将释放monitor(锁)并复位变量的值，
 * 以便其他线程进入获取monitor(锁)。
 *
 *
 *从字节码中可知同步语句块的实现使用的是monitorenter 和 monitorexit 指令，
 * 其中monitorenter指令指向同步代码块的开始位置，monitorexit指令则指明同步代码块的结束位置，
 * 当执行monitorenter指令时，当前线程将试图获取 objectref(即对象锁) 所对应的 monitor 的持有权，
 * 当 objectref 的 monitor 的进入计数器为 0，那线程可以成功取得 monitor，并将计数器值设置为 1，
 * 取锁成功。如果当前线程已经拥有 objectref 的 monitor 的持有权，那它可以重入这个 monitor
 * 重入时计数器的值也会加 1。倘若其他线程已经拥有 objectref 的 monitor 的所有权，那当前线程将被阻塞，
 * 直到正在执行线程执行完毕，即monitorexit指令被执行，执行线程将释放 monitor(锁)并设置计数器值为0 ，
 * 其他线程将有机会持有 monitor 。值得注意的是编译器将会确保无论方法通过何种方式完成，
 * 方法中调用过的每条 monitorenter 指令都有执行其对应 monitorexit 指令，
 * 而无论这个方法是正常结束还是异常结束。为了保证在方法异常完成时 monitorenter 和 monitorexit
 * 指令依然可以正确配对执行，编译器会自动产生一个异常处理器，这个异常处理器声明可处理所有的异常，
 * 它的目的就是用来执行 monitorexit 指令。从字节码中也可以看出多了一个monitorexit指令，
 * 它就是异常结束时被执行的释放monitor 的指令。
 *
 *
 *
 *
 *
 * 优化
 *
 *
 * 偏向锁是Java 6之后加入的新锁，它是一种针对加锁操作的优化手段，
 * 经过研究发现，在大多数情况下，锁不仅不存在多线程竞争，
 * 而且总是由同一线程多次获得，因此为了减少同一线程获取锁(会涉及到一些CAS操作,耗时)的代价而引入偏向锁。
 * 偏向锁的核心思想是，如果一个线程获得了锁，那么锁就进入偏向模式，此时Mark Word 的结构也变为偏向锁结构，
 * 当这个线程再次请求锁时，无需再做任何同步操作，即获取锁的过程，这样就省去了大量有关锁申请的操作，
 * 从而也就提供程序的性能。所以，对于没有锁竞争的场合，偏向锁有很好的优化效果，
 * 毕竟极有可能连续多次是同一个线程申请相同的锁。但是对于锁竞争比较激烈的场合，
 * 偏向锁就失效了，因为这样场合极有可能每次申请锁的线程都是不相同的，因此这种场合下不应该使用偏向锁，
 * 否则会得不偿失，需要注意的是，偏向锁失败后，并不会立即膨胀为重量级锁，而是先升级为轻量级锁
 *
 *
 *
 * 倘若偏向锁失败，虚拟机并不会立即升级为重量级锁，它还会尝试使用一种称为轻量级锁的优化手段(1.6之后加入的)，
 * 此时Mark Word 的结构也变为轻量级锁的结构。轻量级锁能够提升程序性能的依据是“对绝大部分的锁，
 * 在整个同步周期内都不存在竞争”，注意这是经验数据。需要了解的是，轻量级锁所适应的场景是线程交替执行同步块的场合，
 * 如果存在同一时间访问同一锁的场合，就会导致轻量级锁膨胀为重量级锁。
 *
 *
 * 轻量级锁失败后，虚拟机为了避免线程真实地在操作系统层面挂起，还会进行一项称为自旋锁的优化手段。
 * 这是基于在大多数情况下，线程持有锁的时间都不会太长，如果直接挂起操作系统层面的线程可能会得不偿失，
 * 毕竟操作系统实现线程之间的切换时需要从用户态转换到核心态，这个状态之间的转换需要相对比较长的时间，
 * 时间成本相对较高，因此自旋锁会假设在不久将来，当前的线程可以获得锁，
 * 因此虚拟机会让当前想要获取锁的线程做几个空循环(这也是称为自旋的原因)，一般不会太久，
 * 可能是50个循环或100循环，在经过若干次循环后，如果得到锁，就顺利进入临界区。如果还不能获得锁，
 * 那就会将线程在操作系统层面挂起，这就是自旋锁的优化方式，这种方式确实也是可以提升效率的。
 * 最后没办法也就只能升级为重量级锁了。
 *
 *
 *
 * 消除锁是虚拟机另外一种锁的优化，这种优化更彻底，
 * Java虚拟机在JIT编译时(可以简单理解为当某段代码即将第一次被执行时进行编译，又称即时编译)，
 * 通过对运行上下文的扫描，去除不可能存在共享资源竞争的锁，通过这种方式消除没有必要的锁，
 * 可以节省毫无意义的请求锁时间，如下StringBuffer的append是一个同步方法，
 * 但是在add方法中的StringBuffer属于一个局部变量，并且不会被其他线程所使用，
 * 因此StringBuffer不可能存在共享资源竞争的情景，JVM会自动将其锁消除。
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class SynchronizedClass implements Runnable{

    private static int num = 0;

    /**
     * 作用于静态方法,锁是当前class对象,也就是
     * AccountingSyncClass类对应的class对象,
     *
     * 当前class的锁对象在整个jvm中只有一份
     */
    public static synchronized void increase(){
        num++;
    }

    /**
     * 非静态,锁对象指的是当前实例对象，因此不同线程的不同实例访问时锁不一样，
     * 因此不会发生互斥
     */
    public synchronized void increase4Obj(){
        num++;
    }

    @Override
    public void run() {

        for (int i = 0;i < 1000000;i++){
            increase();
        }
    }


    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new SynchronizedClass());
        Thread t2 = new Thread(new SynchronizedClass());

        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(SynchronizedClass.num);
    }
}
