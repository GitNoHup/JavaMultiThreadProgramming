package com.zhang.demo02;

/**
 * 监视器不同，多线程是异步的
 * anyString和this
 */
public class Demo17 {
    public static void main(String[] args) {
        MyDemo17 myDemo17 = new MyDemo17();
        MyThread17A myThread17A = new MyThread17A(myDemo17);
        myThread17A.start();
        MyThread17B myThread17B = new MyThread17B(myDemo17);
        myThread17B.start();
    }
}

class MyThread17A extends Thread {
    private MyDemo17 myDemo17;

    public MyThread17A(MyDemo17 myDemo17) {
        this.myDemo17 = myDemo17;
    }

    @Override
    public void run() {
        myDemo17.myDemo17A();
    }
}

class MyThread17B extends Thread {
    private MyDemo17 myDemo17;

    public MyThread17B(MyDemo17 myDemo17) {
        this.myDemo17 = myDemo17;
    }

    @Override
    public void run() {
        myDemo17.myDemo17B();
    }
}

class MyDemo17 {
    private String anyString = new String();

    public void myDemo17A() {
        try {
            synchronized (anyString) {
                System.out.println("begin A");
                Thread.sleep(3000);
                System.out.println("end A");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void myDemo17B() {
        System.out.println("begin B");
        System.out.println("end B");
    }
}