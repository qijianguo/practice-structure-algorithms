package com.qijianguo.algorithms.muti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer_Synchronized {

    private final List<Integer> container = new ArrayList<>();

    private final int MIN = 0;
    private final int MAX = 10;
    private int count = 0;

    public synchronized void put(Integer number) {
        while (container.size() == MAX) {
            // 等待
            try {
                this.wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        }
        container.add(number);
        ++ count;
        System.out.println("PUT count=" + count + "   size=" + container.size());
        this.notifyAll();
    }

    public synchronized void get() {
        while (container.size() == MIN) {
            // 等待
            try {
                this.wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        container.get(0);
        container.remove(0);
        -- count;
        System.out.println("GET count=" + count + "   size=" + container.size());
        this.notifyAll();
    }

    public static void main(String[] args) {
        ProducerConsumer_Synchronized producerConsumerSync = new ProducerConsumer_Synchronized();
        for (int i = 0; i < 8; i++) {
            Thread consumer = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    producerConsumerSync.get();
                }
            });
            consumer.start();
        }
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            Thread productor = new Thread(() -> {
                for (int j = 0; j < 200; j++) {
                    producerConsumerSync.put(random.nextInt(10));
                }
            });
            productor.start();
        }

    }

}
