package com.qijianguo.algorithms.muti;

public class ThreadLocalTest {

    static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        String a = "aaa";
        threadLocal.set(a);
        Object o = threadLocal.get();
        System.out.println(o);
    }

}
