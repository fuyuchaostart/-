package com.fuyuchao.test;

import java.util.concurrent.Semaphore;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class SemaphoreTest3 {
    public static void main(String[] args) {
        //控制并发量  二 多个资源的互斥性--每次只能访问多个资源中的一个
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "占有了资源");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "离开了资源");
                }
            }).start();
        }

    }
}
