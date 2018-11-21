package com.zhang.demo02;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo39 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        thread1.start();
        Thread thread2 = new Thread(myThread);
        thread2.start();
        Thread thread3 = new Thread(myThread);
        thread3.start();
        Thread thread4 = new Thread(myThread);
        thread4.start();
        Thread thread5 = new Thread(myThread);
        thread5.start();
    }
}

class MyThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("ThreadName:" + Thread.currentThread().getName() + " " + count.incrementAndGet());
        }
    }
}