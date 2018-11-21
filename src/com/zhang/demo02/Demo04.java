package com.zhang.demo02;

public class Demo04 {
    public static void main(String[] args) {
        MyDemo04 myDemo04 = new MyDemo04();
        MyThread04A myThread04A = new MyThread04A(myDemo04);
        MyThread04B myThread04B = new MyThread04B(myDemo04);
        myThread04A.setName("A");
        myThread04B.setName("B");
        myThread04A.start();
        myThread04B.start();
    }
}

class MyThread04A extends Thread {
    private MyDemo04 myDemo04;

    public MyThread04A(MyDemo04 myDemo04) {
        this.myDemo04 = myDemo04;
    }

    @Override
    public void run() {
        myDemo04.myMethod04();
    }
}

class MyThread04B extends Thread {
    private MyDemo04 myDemo04;

    public MyThread04B(MyDemo04 myDemo04) {
        this.myDemo04 = myDemo04;
    }

    @Override
    public void run() {
        myDemo04.myMethod04();
    }
}

class MyDemo04 {
    synchronized public void myMethod04() {
        try {
            System.out.println("print:" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}