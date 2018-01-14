package com.fuyuchao.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class CylicBarrierTest {
    private static final int COUNT = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT, () -> {
            System.out.println(Thread.currentThread().getName() + "   所有程序就位.....");
        });
        for (int i = 0; i < 7; i++) {
            int desk = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 就位了 " + desk);
                try {
                    //  System.out.print("   " + cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }

}


