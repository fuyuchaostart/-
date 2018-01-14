package com.fuyuchao.test;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月22
 *          天变不足畏，祖宗不足法，人言不足恤
 */
public class ConcurrentCollectionTest {

    /**
     * ArrayList的安全问题和解决方式
     */
    @Test
    public void fun1() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(() -> {
                list.add(finalI);
                System.out.println(list);
            }).start();
        }
        System.out.println(list);
    }

    /**
     * SET的安全问题和解决方式
     */
    @Test
    public void fun2() {
//        Set<Integer> set = new HashSet<>();
        Set<Integer> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            new Thread(() -> {
                set.add(finalI);
                System.out.println(set);
            }).start();

        }

    }

    /**
     * HashMap的安全问题和解决方式
     */
    @Test
    public void fun3() {
//        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                map.put("" + finalI, finalI);
                System.out.println(map);
            }).start();
        }
    }

}
