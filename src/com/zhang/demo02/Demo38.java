package com.zhang.demo02;

/**
 * volatile关键字只能保证可见性，不支持原子性
 * 加上synchronized，线程就是同步的了
 */
public class Demo38 {
    public static void main(String[] args) {
        MyThread38[] myThread38 = new MyThread38[100];
        for (int i = 0; i < 100; i++) {
            myThread38[i] = new MyThread38();
        }
        for (int i = 0; i < 100; i++) {
            myThread38[i].start();
        }
    }
}

class MyThread38 extends Thread {
    volatile public static int count;

    synchronized private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("ThreadName:" + Thread.currentThread().getName() + "count:" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}