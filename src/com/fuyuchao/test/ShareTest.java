package com.fuyuchao.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class ShareTest {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                share.outBy5(i);

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                share.outBy10(i);

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                share.outBy15(i);

            }
        }).start();
    }
}

class Share {

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void outBy5(int totuLing) {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("number  " + i + "   AA     " + totuLing);
            }
            condition2.signal();
            number = 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void outBy15(int totuLing) {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("number  " + i + "    CC     " + totuLing);
            }
            condition1.signal();
            number = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void outBy10(int totuLing) {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("number  " + i + "   BB     " + totuLing);
            }
            condition3.signal();
            number = 3;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
