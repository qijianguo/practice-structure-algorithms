package com.qijianguo.algorithms.muti;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class H2OTest {

    public static void main(String[] args) {

        String[] string = new String[150];
        for (int i = 0; i < string.length; i++) {
            if (i % 3 == 0) {
                string[i] = "O";
            } else {
                string[i] = "H";
            }
        }
        List<String> list = Arrays.asList(string);
        Collections.shuffle(list);

        list.forEach(s -> {
            H2O h2O = new H2O();
            try {
                Thread thread = new Thread();
                h2O.hydrogen(thread);
                h2O.oxygen(thread);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        System.out.println(string);
    }
}
