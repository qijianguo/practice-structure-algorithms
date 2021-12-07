package com.qijianguo.algorithms.muti;

public class FooBarTest {

    public static void main(String[] args) throws InterruptedException {

        FooBar fooBar = new FooBar(20);
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> System.out.println(""));
            fooBar.foo(thread);
            fooBar.bar(thread);
            thread.start();
        }

    }
}
