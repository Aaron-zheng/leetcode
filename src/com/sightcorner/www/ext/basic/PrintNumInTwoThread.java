package com.sightcorner.www.ext.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Aaron Zheng<br>
 * Created at 22/12/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 22/12/2019
 */
public class PrintNumInTwoThread {


    /**
     * 2个线程，轮流打印数字，例如线程1打印奇数，线程2打印偶数
     *
     * @param args
     */
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        AtomicBoolean b1 = new AtomicBoolean(true);
        AtomicBoolean b2 = new AtomicBoolean(false);
        AtomicInteger num = new AtomicInteger(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    if(num.get() > 100) {
                        break;
                    }
                    if(b1.get()) {
                        System.out.println("thread1 " + num.getAndIncrement());
                        b2.set(true);
                        b1.set(false);
                    }
                }
            }
        }).start();

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    if(num.get() > 100) {
                        break;
                    }
                    if(b2.get()) {
                        System.out.println("thread2 " + num.getAndIncrement());
                        b1.set(true);
                        b2.set(false);
                    }
                }
            }
        }).start();
    }
}
