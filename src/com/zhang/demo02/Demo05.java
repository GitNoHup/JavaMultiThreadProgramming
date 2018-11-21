package com.zhang.demo02;

/**
 * 两个方法都是用synchronized修饰的，在获得这个类的synchronized对象时，另外一个方法需要等待
 */
public class Demo05 {
    public static void main(String[] args) {
        MyDemo05 myDemo05 = new MyDemo05();
        MyThread05A myThread05A = new MyThread05A(myDemo05);
        myThread05A.setName("A");
        myThread05A.start();
        MyThread05B myThread05B = new MyThread05B(myDemo05);
        myThread05B.setName("B");
        myThread05B.start();
    }
}

class MyThread05A extends Thread {
    private MyDemo05 myDemo05;

    public MyThread05A(MyDemo05 myDemo05) {
        this.myDemo05 = myDemo05;
    }

    @Override
    public void run() {
        myDemo05.myMethod05A();
    }
}

class MyThread05B extends Thread {
    private MyDemo05 myDemo05;

    public MyThread05B(MyDemo05 myDemo05) {
        this.myDemo05 = myDemo05;
    }

    @Override
    public void run() {
        myDemo05.myMethod05B();
    }
}

class MyDemo05 {
    synchronized public void myMethod05A() {
        try {
            System.out.println("printA:" + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("end A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void myMethod05B() {
        System.out.println("printB:" + Thread.currentThread().getName());
        System.out.println("end B");
    }
}