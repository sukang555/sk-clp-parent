package com.skse.se.jvm.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author sukang on 2019/6/11.
 * 一:
 *      1.不带返回值的异步线程操作
 *      public static CompletableFuture<Void> runAsync(Runnable runnable)
 *      public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
 *
 *      2.带返回值的异步线程操作
 *      public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
 *      public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
 *
 *
 * 二 计算结果完成时的回调方法
 *      1.是执行当前任务的线程执行继续执行 whenComplete 的任务
 *      public CompletableFuture<T> whenComplete(BiConsumer<? super T,? super Throwable> action)
 *      2.将whenComplete 的任务 交给线程池继续处理
 *      public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action)
 *      public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor)
 *
 *      //异常的回调方法
 *      public CompletableFuture<T> exceptionally(Function<Throwable,? extends T> fn)
 *
 *
 *三  thenApply 方法
 *
 *      当一个线程依赖另一个线程时，可以使用 thenApply 方法来把这两个线程串行化,
 *      出现异常不会再继续执行
 *      public <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
 *      public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn)
 *      public <U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)
 *
 *    handle 方法 任务完成后再执行,可以处理异常
 *      public <U> CompletionStage<U> handle(BiFunction<? super T, Throwable, ? extends U> fn);
 *      public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn);
 *      public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn,Executor executor);
 *
 *
 * 四  thenAccept 消费处理结果
 *
 *      接收任务的处理结果，并消费处理，无返回结果。
 *      public CompletionStage<Void> thenAccept(Consumer<? super T> action);
 *      public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action);
 *      public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action,Executor executor);
 *
 *    thenRun 方法跟 thenAccept 方法不一样的是,不关心任务的处理结果.
 *    只要上面的任务执行完成，就开始执行 thenAccept.
 *      public CompletionStage<Void> thenRun(Runnable action);
 *      public CompletionStage<Void> thenRunAsync(Runnable action);
 *      public CompletionStage<Void> thenRunAsync(Runnable action,Executor executor);
 *
 *
 *
 *
 *
 */
@Slf4j
public class CompletableFuture {

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo").build();

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            2,5, 0L,
            TimeUnit.MINUTES,new LinkedBlockingQueue<>(100),threadFactory);


    @Test
    public void main2(){
        log.info("hello world");
    }

    @Test
    public void main1(){
        try {

            long start = System.currentTimeMillis();
            Future<Integer> future = threadPool.submit(() -> {

                int sum = 0;

                for (int i = 0; i <= 5000000 ; i++) {
                    sum += i;
                }
                log.info(Thread.currentThread().getId()+"::--"+Thread.currentThread().getName());
                return sum;
            });

            Future<Integer> submit = threadPool.submit(() -> {

                int sum = 0;

                for (int i = 5000001; i <= 100000000; i++) {
                    sum += i;
                }
                log.info(Thread.currentThread().getId()+"::--"+Thread.currentThread().getName());
                return sum;
            });

            System.out.println(submit.get()
                    + future.get());

            log.info("耗时" + (System.currentTimeMillis() - start));





        }catch (Exception e){
            e.printStackTrace();
        }


    }


    @Test
    public void main3(){

       try {


            java.util.concurrent.CompletableFuture<Long> future = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
                Long sum = 0L;

                for (int i = 0; i <= 5000000 ; i++) {
                    sum += i;
                }
                return sum;
            },threadPool);

           java.util.concurrent.CompletableFuture<Long> future2 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
               Long sum = 0L;

               for (int i = 5000001; i <= 100000000 ; i++) {
                   sum += i;
               }
               try {
                   TimeUnit.SECONDS.sleep(5);
               }catch (Exception e){
                   e.printStackTrace();
               }
               return sum;
           },threadPool);

           System.out.println("开始等待");
           java.util.concurrent.CompletableFuture.allOf(future2, future).join();

           System.out.println(future.get()+future2.get());

       }catch (Exception e){
            e.printStackTrace();
        }

    }












}
