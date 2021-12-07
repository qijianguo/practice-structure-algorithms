package com.qijianguo.algorithms.threadpool;

import java.util.concurrent.CompletableFuture;

/**
 * @author qijianguo
 * CompletableFuture 管理多个Future的结果
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        // 多个任务异步执行，并
        CompletableFuture futureA = CompletableFuture.supplyAsync(() -> a());
        CompletableFuture futureB = CompletableFuture.supplyAsync(() -> b());

        CompletableFuture.allOf(futureA, futureB).join();

    }
    private static int a() {
        return 1;
    }

    private static int b() {
        return 2;
    }
}
