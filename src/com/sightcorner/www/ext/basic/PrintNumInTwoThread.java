package com.sightcorner.www.ext.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
//        test1();
//        test2();
    }

    /**
     * 通过锁状态，限制。然后通过state更新当前线程
     */
    public static void test2() {
        Lock lock = new ReentrantLock();
        final AtomicInteger state = new AtomicInteger(0);
        AtomicInteger num = new AtomicInteger(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    if(num.get() > 100) {
                        break;
                    }
                    lock.lock();
                    if(state.get() % 2 == 0) {
                        System.out.println("thread1 " + num.getAndIncrement());
                        state.getAndIncrement();
                    }
                    lock.unlock();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    if(num.get() > 100) {
                        break;
                    }
                    lock.lock();
                    if(state.get() % 2 == 1) {
                        System.out.println("thread2 " + num.getAndIncrement());
                        state.getAndIncrement();
                    }
                    lock.unlock();
                }
            }
        }).start();
    }


    /**
     * 采用2个变量控制，坏处是for循环会消耗cpu
     */
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
