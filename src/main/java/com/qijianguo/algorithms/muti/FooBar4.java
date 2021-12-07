package com.qijianguo.algorithms.muti;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 */
public class FooBar4 {

    private int n;

    // 执行类型
    private volatile boolean isFoo = true;

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!isFoo) {
                    condition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFoo = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (isFoo) {
                    condition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isFoo = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

}
