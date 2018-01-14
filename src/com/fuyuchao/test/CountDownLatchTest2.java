package com.fuyuchao.test;

import com.fuyuchao.Country;

import java.util.concurrent.CountDownLatch;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class CountDownLatchTest2 {
    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                //每次调用减一,直至为零时唤醒被这个对象await()阻塞的线程
                downLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " 国被灭");
            }, Country.getCountry(i).getName()).start();
        }
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大秦帝国统一天下");
    }
}
