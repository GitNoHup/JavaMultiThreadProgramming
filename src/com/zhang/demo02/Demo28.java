package com.zhang.demo02;

/**
 * String有常量池，两个线程的值都是AA，所以两个线程争抢相同的锁
 * 导致只有一个线程可以执行
 */
public class Demo28 {
    public static void main(String[] args) {
        MyDemo28 myDemo28 = new MyDemo28();

        MyThread28A myThread28A = new MyThread28A(myDemo28);
        myThread28A.setName("A");
        myThread28A.start();
        MyThread28B myThread28B = new MyThread28B(myDemo28);
        myThread28B.setName("B");
        myThread28B.start();
    }
}

class MyThread28A extends Thread {
    private MyDemo28 myDemo28;

    public MyThread28A(MyDemo28 myDemo28) {
        this.myDemo28 = myDemo28;
    }

    @Override
    public void run() {
        myDemo28.myDemo("AA");
    }
}

class MyThread28B extends Thread {
    private MyDemo28 myDemo28;

    public MyThread28B(MyDemo28 myDemo28) {
        this.myDemo28 = myDemo28;
    }

    @Override
    public void run() {
        myDemo28.myDemo("AA");
    }
}

class MyDemo28 {
    public void myDemo(String param) {
        try {
            synchronized (param) {
                while (true) {
                    System.out.println("ThreadName:" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}