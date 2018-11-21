package com.zhang.demo02;

public class Demo30 {
    public static void main(String[] args) {
        MyDemo30 myDemo30 = new MyDemo30();

        MyThread30A myThread30A = new MyThread30A(myDemo30);
        myThread30A.setName("A");
        myThread30A.start();

        MyThread30B myThread30B = new MyThread30B(myDemo30);
        myThread30B.setName("B");
        myThread30B.start();
    }
}

class MyThread30A extends Thread {
    private MyDemo30 myDemo30;

    public MyThread30A(MyDemo30 myDemo30) {
        this.myDemo30 = myDemo30;
    }

    @Override
    public void run() {
        myDemo30.myDemoA();
    }
}

class MyThread30B extends Thread {
    private MyDemo30 myDemo30;

    public MyThread30B(MyDemo30 myDemo30) {
        this.myDemo30 = myDemo30;
    }

    @Override
    public void run() {
        myDemo30.myDemoB();
    }
}

class MyDemo30 {
    Object objectA = new Object();

    public void myDemoA() {
        synchronized (objectA) {
            System.out.println("Start ThreadName:" + Thread.currentThread().getName());
            boolean isContinueRun = true;
            while (isContinueRun) {

            }
            System.out.println("End ThreadName:" + Thread.currentThread().getName());
        }
    }

    Object objectB = new Object();

    public void myDemoB() {
        synchronized (objectB) {
            System.out.println("Start ThreadName:" + Thread.currentThread().getName());
            System.out.println("End ThreadName:" + Thread.currentThread().getName());
        }
    }
}