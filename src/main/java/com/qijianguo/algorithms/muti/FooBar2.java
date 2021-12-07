package com.qijianguo.algorithms.muti;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

/**
 * BlockingQueue
 */
public class FooBar2 {

    private int n;

    private BlockingQueue foo = new LinkedBlockingDeque(1);
    private BlockingQueue bar = new LinkedBlockingDeque(1);

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.put(i);
            bar.put(i);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.take();
        }
    }
}
