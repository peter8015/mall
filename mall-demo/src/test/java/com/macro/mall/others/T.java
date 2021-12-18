package com.macro.mall.others;

import java.util.concurrent.TimeUnit;

/**
 * volatile test
 */
public class T {
    volatile boolean running = true;

    void m() {
        System.out.println("m start!");

        while(running) {
//            System.out.println("mmmmm");
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T t = new T();

        StringBuilder sb = new StringBuilder();
        sb.append("aaa").append("bbb");

        String a = "abc";
        StringBuffer sb1 = new StringBuffer();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}


