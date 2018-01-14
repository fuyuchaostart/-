package com.fuyuchao.test;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class ExecutesTest {
    @Test
    public void fun1() {
        try {
            threadPoolSchdule();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void threadPoolSchdule() throws InterruptedException, ExecutionException {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            ScheduledFuture<Integer> schedule = threadPool.schedule(() -> {
                int number = new Random().nextInt(30);
                System.out.print(Thread.currentThread().getName() + "  " + number);
                return number;
            }, 2, TimeUnit.NANOSECONDS);
            System.out.println("  返回结果--" + schedule.get());
        }
    }

    private void cacheThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        threadExe(executorService);
    }

    private void threadPoolSingle() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        threadExe(executorService);

    }

    private void threadExe(ExecutorService executorService) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            Future future = executorService.submit(() -> {
                int number = new Random().nextInt(30);
                System.out.print(Thread.currentThread().getName() + "  " + number);
                return number;
            });
            System.out.println("  返回结果--" + future.get());
        }
    }

    private void fixedThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        threadExe(executorService);

    }
}
