package com.qijianguo.algorithms.muti;

import java.io.IOException;

public class NormalReferenceTest {

    public static void main(String[] args) throws IOException {
        // 默认引用（强应用），只要有引用指向对象，就一定不会回收
        M m = new M();
        m = null;     // 释放引用
        System.gc();
        System.out.println(m);
        System.in.read();   // 为了测试，阻塞main主线程
    }

    static class M {
        @Override
        protected void finalize() {
            System.out.println("finalize");
        }
    }

}
