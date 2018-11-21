package com.zhang.demo02;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Atomic系列 原子类
 * 使用不当，也会造成不同步现象
 */
public class Demo40 {
    public static void main(String[] args) {
        MyDemo40 myDemo40 = new MyDemo40();
        MyThread40[] myThread40s = new MyThread40[5];
        for (int i = 0; i < myThread40s.length; i++) {
            myThread40s[i] = new MyThread40(myDemo40);
        }
        for (int i = 0; i < myThread40s.length; i++) {
            myThread40s[i].start();
        }

        try {
            Thread.sleep(1000);
            System.out.println("long:" + MyDemo40.atomicLong.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread40 extends Thread {
    private MyDemo40 myDemo40;

    public MyThread40(MyDemo40 myDemo40) {
        this.myDemo40 = myDemo40;
    }

    @Override
    public void run() {
        myDemo40.addNum();
    }
}

class MyDemo40 {
    public static AtomicLong atomicLong = new AtomicLong();

    /**
     * addAndGet是原子的
     * 但是
     * addNum方法的调用不是原子的
     * <p>
     * 解决方案：
     * addNum方法加上synchronized，方法就是同步的了
     */
    public void addNum() {
        System.out.println("ThreadName:" + Thread.currentThread().getName() + "加了100以后：" + atomicLong.addAndGet(100));
        atomicLong.addAndGet(1);
    }
}