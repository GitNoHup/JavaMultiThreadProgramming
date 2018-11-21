package com.zhang.demo02;

/**
 * 异步原因：
 * 一个是对象锁，一个是class锁
 * class锁可以对类的所有对象实例起作用
 */
public class Demo25 {
    public static void main(String[] args) {
        MyObject25 myObject25 = new MyObject25();

        MyThread25A myThread25A = new MyThread25A(myObject25);
        myThread25A.setName("A");
        myThread25A.start();
        MyThread25B myThread25B = new MyThread25B(myObject25);
        myThread25B.setName("B");
        myThread25B.start();
        MyThread25C myThread25C = new MyThread25C(myObject25);
        myThread25C.setName("C");
        myThread25C.start();
    }
}

class MyThread25A extends Thread {
    MyObject25 myObject25;

    public MyThread25A(MyObject25 myObject25) {
        this.myObject25 = myObject25;
    }

    @Override
    public void run() {
        myObject25.MyObjectA();
    }
}

class MyThread25B extends Thread {
    MyObject25 myObject25;

    public MyThread25B(MyObject25 myObject25) {
        this.myObject25 = myObject25;
    }

    @Override
    public void run() {
        myObject25.MyObjectB();
    }
}

class MyThread25C extends Thread {
    MyObject25 myObject25;

    public MyThread25C(MyObject25 myObject25) {
        this.myObject25 = myObject25;
    }

    @Override
    public void run() {
        myObject25.MyObjectC();
    }
}

class MyObject25 {
    synchronized public static void MyObjectA() {
        try {
            System.out.println("A ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("A ThreadName:" + Thread.currentThread().getName() + "   end time:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void MyObjectB() {
        System.out.println("B ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
        System.out.println("B ThreadName:" + Thread.currentThread().getName() + "   end time:" + System.currentTimeMillis());
    }

    public static void MyObjectC() {
        System.out.println("C ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
        System.out.println("C ThreadName:" + Thread.currentThread().getName() + "   end time:" + System.currentTimeMillis());
    }
}