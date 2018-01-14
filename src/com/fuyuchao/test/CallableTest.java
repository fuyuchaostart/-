package com.fuyuchao.test;

import java.util.concurrent.FutureTask;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class CallableTest {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println("操作..................");
            return Thread.currentThread().getName() + "  使用callAble开启子线程";
        });
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();

    }
}


