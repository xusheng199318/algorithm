package com.arthur.cur;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolTest {

    @Test
    public void testThreadPool() {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(1, 3,1000, TimeUnit.SECONDS, new ArrayBlockingQueue(2));
        tpe.execute(() -> System.out.println("haha"));
        int i = -1 << 29;
        System.out.println(i);
        System.out.println(i & (~536870911));
        System.out.println(-536870912 | 0);
    }

    @Test
    public void testMyThreadPool() throws InterruptedException {
        MyThreadPool threadPool = new MyThreadPool(1, 3, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        threadPool.execute(() -> System.out.println("Hello My Thead Pool"));
        Thread.sleep(1000);
    }
}
