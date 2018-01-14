package com.fuyuchao.test;

import java.util.concurrent.TimeUnit;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月20
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class Lock8thTest {
    public static void main(String[] args) {
        phone phone = new phone();
        new Thread(() -> {
            phone.getIOS();
        }).start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(() -> {
//            phone.getAndroid();
            phone.HelloMeth();
        }).start();

    }


}

class phone {

    public synchronized void getIOS() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("**********getIOS***********");
    }

    public synchronized void getAndroid() {
        System.out.println("**********getAndroid***********");
    }

    public void HelloMeth() {
        System.out.println("**********getHello***********");
    }
}
