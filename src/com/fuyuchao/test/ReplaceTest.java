package com.fuyuchao.test;

import javafx.scene.chart.Chart;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月20
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class ReplaceTest {
    public static void main(String[] args) {
        ReplaceOut replaceOut = new ReplaceOut();
        new Thread(() -> {
            while (true) {
                replaceOut.outLetter();
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                replaceOut.outNumber();
            }
        }).start();

    }
}

class ReplaceOut {
    private char[] letters = new char[26];
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    {
        int count = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            letters[count] = i;
            count++;
        }
    }

    public void outNumber() {
        lock.lock();
        try {
            System.out.print(++number);
            System.out.print(++number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            condition.signalAll();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    public void outLetter() {
        lock.lock();
        try {
            if (number != 0) {
                System.out.print(letters[(number / 2) - 1] + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            condition.signalAll();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}
