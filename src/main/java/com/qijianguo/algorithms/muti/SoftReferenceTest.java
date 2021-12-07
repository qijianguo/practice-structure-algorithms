package com.qijianguo.algorithms.muti;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        SoftReference m = new SoftReference(new byte[1024 * 1024 * 10]); // 初始化一个10M的内存空间
        System.out.println("调用gc前：" + m.get());  // 打印

        System.gc();    // 垃圾回收

        System.out.println("调用gc后：" + m.get());

        Thread.sleep(500);

        // 手动控制JVM的参数   -Xms20M -Xmx20M
        byte [] bytes =  new byte[1024 * 1024 * 15];    // 申请一个15M的内存空间, 如果内存够用，则正常申请；
                                                        // 如果内存不够，则会启用一次gc, 如果申请的内存空间不够用，会吧软引用干掉

        System.out.println("申请空间：" + m.get());

    }

}
