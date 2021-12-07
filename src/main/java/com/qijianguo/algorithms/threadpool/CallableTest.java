package com.qijianguo.algorithms.threadpool;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(1000);
                return 10000;
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Object> submit = executorService.submit(callable);// 异步
        System.out.println(submit.get()); // 阻塞
        executorService.shutdown();

    }
}
