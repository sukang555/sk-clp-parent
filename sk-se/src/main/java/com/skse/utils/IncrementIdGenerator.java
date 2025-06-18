package com.skse.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 毫秒级自增ID生成器（线程安全）
 * 结构
 */
public class IncrementIdGenerator {
    /**
     * 同一天最大的毫秒数差值为 86400000 一共8位数字 所以剩余2位序列号
     */
    private static final long CurrentDayStart = LocalDate.now().atStartOfDay(
            ZoneId.systemDefault()).toInstant().toEpochMilli();

    //序列号最大长度 2位数字
    private static final int SEQUENCE_LENGTH = 2;

    private static final int MAX_SEQUENCE = (int) Math.pow(10, SEQUENCE_LENGTH) - 1; // 序列号最大值

    private static final AtomicInteger sequence = new AtomicInteger(0); // 序列号计数器

    private static long lastTimestamp = -1L; // 上一次生成ID的时间戳

    /**
     * 生成唯一自增ID（线程安全）
     */
    public static synchronized String nextId() {
        long currentTimestamp = getCurrentTimestamp();

        if (currentTimestamp < lastTimestamp) {
            if (currentTimestamp - lastTimestamp < 3000){
                currentTimestamp = waitUntilNextMillis(currentTimestamp);
            }else {
                throw new RuntimeException("系统时钟回拨，拒绝生成ID");
            }

        }

        if (currentTimestamp == lastTimestamp) {
            // 同一毫秒内，递增序列号
            int currentSeq = sequence.incrementAndGet();
            if (currentSeq > MAX_SEQUENCE) {
                // 序列号溢出，等待到下一毫秒
                currentTimestamp = waitUntilNextMillis(currentTimestamp);

                sequence.set(0); // 重置序列号
            }
        } else {
            // 时间戳变化，重置序列号
            sequence.set(0);
        }

        lastTimestamp = currentTimestamp;

        // 组合ID：时间戳 << 序列号位数 | 序列号
        return currentTimestamp - CurrentDayStart
                + StringUtils.leftPad(String.valueOf(sequence.get()), SEQUENCE_LENGTH,'0');
    }

    /**
     * 获取当前时间戳（毫秒）
     */
    private static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 阻塞等待直到下一毫秒
     */
    private static long waitUntilNextMillis(long currentTimestamp) {
        long nextTimestamp = getCurrentTimestamp();
        while (nextTimestamp <= currentTimestamp) {
            nextTimestamp = getCurrentTimestamp();
        }
        return nextTimestamp;
    }

    // 测试代码
    public static void main(String[] args) {
        long currentMillis = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            System.out.println("生成的ID: " + nextId());
        }

        System.out.println(System.currentTimeMillis() - currentMillis);
    }
}