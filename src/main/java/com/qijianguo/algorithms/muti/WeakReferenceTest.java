package com.qijianguo.algorithms.muti;

import java.lang.ref.WeakReference;

/**
 * 弱引用只要垃圾回收器执行就会被回收
 *
 * 强引用被回收后，弱引用应该被回收
 *
 * 一般用在容器中
 *
 * e.g.WeakHashMap
 * ThreadLocal
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        WeakReference m = new WeakReference(new byte[1024 * 1024 * 10]);
        System.out.println("调用gc前：" + m.get());
        System.gc();    // 垃圾回收, 直接回收m
        System.out.println("调用gc后：" + m.get());
    }
}
