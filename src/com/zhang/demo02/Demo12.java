package com.zhang.demo02;

public class Demo12 {
    public static void main(String[] args) {
        MyDemo12 myDemo12 = new MyDemo12();
        MyThread12A myThread12A = new MyThread12A(myDemo12);
        myThread12A.start();
        MyThread12B myThread12B = new MyThread12B(myDemo12);
        myThread12B.start();
    }
}

class MyThread12A extends Thread {
    private MyDemo12 myDemo12;

    public MyThread12A(MyDemo12 myDemo12) {
        this.myDemo12 = myDemo12;
    }

    @Override
    public void run() {
        myDemo12.myDemo12();
    }
}

class MyThread12B extends Thread {
    private MyDemo12 myDemo12;

    public MyThread12B(MyDemo12 myDemo12) {
        this.myDemo12 = myDemo12;
    }

    @Override
    public void run() {
        myDemo12.myDemo12();
    }
}

class MyDemo12 {
    public void myDemo12() {
        try {
            synchronized (this) {
                System.out.println("begin time:" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time:" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}