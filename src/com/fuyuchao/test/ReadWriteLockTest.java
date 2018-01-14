package com.fuyuchao.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
class ReadWriteLockTest {
    private Object object = null;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockTest readWriteLock = new ReadWriteLockTest();
        new Thread(() -> {
            readWriteLock.writeTest("周大神,JVM ,Thread,线程 操作  资源类");
        }).start();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                readWriteLock.readTest();
            }, "read....." + i).start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                readWriteLock.readTest2();
            }, "read....." + (i + 100)).start();
        }


    }

    public void readTest() {
        readWriteLock.readLock().lock();
        try {
            Thread.sleep(3000);
            System.out.println("我是读锁1号------" + object);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void readTest2() {
        readWriteLock.readLock().lock();
        try {
            System.out.println("我是读锁2号------" + object);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void writeTest(Object object) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println("我是写锁");
            this.object = object;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

}