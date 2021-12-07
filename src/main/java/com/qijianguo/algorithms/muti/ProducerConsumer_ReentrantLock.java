package com.qijianguo.algorithms.muti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer_ReentrantLock {

    private final List<Integer> container = new ArrayList<>();

    private final int MIN = 0;
    private final int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();


    public void put(Integer num) {
        lock.lock();
        try {
            while (container.size() == MAX) {
                producer.await();
            }
            container.add(num);
            ++ count;
            System.out.println("PUT count=" + count + "   size=" + container.size());
            consumer.signalAll();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            while (container.size() == MIN) {
                try {
                    consumer.await();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            container.get(0);
            container.remove(0);
            --count;
            System.out.println("GET count=" + count + "   size=" + container.size());
            producer.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ProducerConsumer_ReentrantLock producerConsumerLock = new ProducerConsumer_ReentrantLock();
        for (int i = 0; i < 8; i++) {
            Thread consumer = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    producerConsumerLock.get();
                }
            });
            consumer.start();
        }
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Thread productor = new Thread(() -> {
                for (int j = 0; j < 200; j++) {
                    producerConsumerLock.put(random.nextInt(10));
                }
            });
            productor.start();
        }

    }
}
