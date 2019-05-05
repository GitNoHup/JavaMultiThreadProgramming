package com.zhang.demo03;

public class Demo06 {
    public static void main(String[] args) {
        Object object = new Object();
        MyThread06A myThread06A = new MyThread06A(object);
        myThread06A.start();
        MyThread06B myThread06B = new MyThread06B(object);
        myThread06B.start();
    }
}

class MyThread06A extends Thread {
    private Object object;

    public MyThread06A(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        MyDemo06 myDemo06 = new MyDemo06();
        myDemo06.myDemo06(object);
    }
}

class MyThread06B extends Thread {
    private Object object;

    public MyThread06B(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        MyDemo06 myDemo06 = new MyDemo06();
        myDemo06.myDemo06(object);
    }
}

class MyDemo06 {
    public void myDemo06(Object object) {
        try {
            synchronized (object) {
                System.out.println("开始！");
                object.wait();
                Thread.sleep(1000);
                System.out.println("结束！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}