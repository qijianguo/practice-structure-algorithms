package com.qijianguo.algorithms.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qijianguo
 * 线程池
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),    // 传各种BlockingQueue
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()    // 拒绝策略
        );
    }
}
