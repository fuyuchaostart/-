package com.fuyuchao.test;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class LockTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {

        final LockTest test = new LockTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    test.increase();
            }).start();
        }
        try {
            System.out.println("------------------");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
//            Thread.yield();
        System.out.println(test.inc);

    }
}


