package com.qijianguo.algorithms.muti;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();    // 模拟
        lock.unlock();
        lock.lock();    // 模拟
    }
}
