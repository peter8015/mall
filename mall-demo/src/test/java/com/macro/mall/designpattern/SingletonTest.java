package com.macro.mall.designpattern;

import org.junit.Test;

public class SingletonTest {
    @Test
    public void t1() {
        Singleton t1 = Singleton.getInstance();
        Singleton t2 = Singleton.getInstance();

        System.out.println(t1 == t2);
    }

    @Test
    public void t2() {
        for(int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton.getInstance().hashCode());
            }).start();
        }
    }
}
