package com.sightcorner.www.ext.threadpool;

import java.util.concurrent.*;

/**
 * Created by Aaron Zheng<br>
 * Created at 11/5/2019<br>
 * Purpose <br>
 * fucheng.zheng@gmail.com<br>
 * <p>
 * Hisotry
 * <p>
 * 1.0 11/5/2019
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("rejected " + ((TestRunnable)r).getCount());
                    }
                });
        for(int i = 0; i < 15; i++) {
            executor.submit(new TestRunnable(i));
        }
    }


    static class TestRunnable implements Runnable {

        public TestRunnable(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        private int count;

        @Override
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count);
        }
    }
}
