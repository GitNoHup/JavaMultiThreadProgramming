package com.zhang.demo02;

public class Demo24 {
    public static void main(String[] args) {
        MyThread24A myThread24A = new MyThread24A();
        myThread24A.setName("A");
        myThread24A.start();

        MyThread24B myThread24B = new MyThread24B();
        myThread24B.setName("B");
        myThread24B.start();
    }
}

class MyThread24A extends Thread {
    @Override
    public void run() {
        MyDemo24.myDemo24A();
    }
}

class MyThread24B extends Thread {
    @Override
    public void run() {
        MyDemo24.myDemo24B();
    }
}

class MyDemo24 {
    synchronized public static void myDemo24A() {
        try {
            System.out.println("A ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("A ThreadName:" + Thread.currentThread().getName() + " end time:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void myDemo24B() {
        System.out.println("B ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
        System.out.println("B ThreadName:" + Thread.currentThread().getName() + " end time:" + System.currentTimeMillis());
    }
}