package com.zhang.demo02;

/**
 * 虽然不是同一个对象，静态的同步方法还是同步运行的
 */
public class Demo26 {
    public static void main(String[] args) {
        MyDemo26 myDemo26A = new MyDemo26();
        MyDemo26 myDemo26B = new MyDemo26();

        MyThread26A myThread26A = new MyThread26A(myDemo26A);
        myThread26A.setName("A");
        myThread26A.start();
        MyThread26B myThread26B = new MyThread26B(myDemo26B);
        myThread26B.setName("B");
        myThread26B.start();
    }
}

class MyThread26A extends Thread {
    MyDemo26 myDemo26;

    public MyThread26A(MyDemo26 myDemo26) {
        this.myDemo26 = myDemo26;
    }

    @Override
    public void run() {
        myDemo26.myDemoA();
    }
}

class MyThread26B extends Thread {
    MyDemo26 myDemo26;

    public MyThread26B(MyDemo26 myDemo26) {
        this.myDemo26 = myDemo26;
    }

    @Override
    public void run() {
        myDemo26.myDemoB();
    }
}

class MyDemo26 {
    synchronized public static void myDemoA() {
        try {
            System.out.println("A ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("A ThreadName:" + Thread.currentThread().getName() + "   end time:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void myDemoB() {
        System.out.println("B ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
        System.out.println("B ThreadName:" + Thread.currentThread().getName() + "   end time:" + System.currentTimeMillis());
    }
}