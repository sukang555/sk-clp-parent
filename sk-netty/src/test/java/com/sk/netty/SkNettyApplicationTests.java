package com.sk.netty;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SkNettyApplicationTests {

    @Test
    public void testScheduleWithFixedDelay() throws InterruptedException {

        // 创建调度任务线程池

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);

        // 按照上次执行完成后固定延迟时间调度

        scheduledExecutorService.scheduleWithFixedDelay(() -> {

            log.info("scheduleWithFixedDelay ...");


        }, 1000, 5000, TimeUnit.MILLISECONDS);



        TimeUnit.HOURS.sleep(1);


    }

}
