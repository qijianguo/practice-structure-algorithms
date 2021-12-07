package com.qijianguo.algorithms.muti;

public class H2O {

    private Object lock = new Object();

    private int hydrogenCount;

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lock) {
            while (hydrogenCount == 2) {
                lock.notifyAll();
                lock.wait();
            }
            hydrogenCount ++;
            lock.notifyAll();
            releaseHydrogen.run();

        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock) {
            while (hydrogenCount != 2) {
                lock.notifyAll();
                lock.wait();
            }
            releaseOxygen.run();
            lock.notifyAll();
        }

    }
}
