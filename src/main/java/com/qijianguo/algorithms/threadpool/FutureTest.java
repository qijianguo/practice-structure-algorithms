package com.qijianguo.algorithms.threadpool;

import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*Future<Integer> future = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            return 100;
        });*/
        FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(1);
                return 100;
            }
        });
        System.out.println(future.isDone());;
        new Thread(future).start();
        System.out.println(future.get());
        System.out.println(future.isDone());;

    }
}
