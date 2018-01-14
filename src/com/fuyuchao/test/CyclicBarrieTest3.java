package com.fuyuchao.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class CyclicBarrieTest3 {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(6, () -> {
            System.out.println("人员全部到齐");
        });
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "到达--被阻塞");
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
