package com.zhang.demo02;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法A和方法B是线程同步的
 * 变量list是公用的
 * 所以仍然会造成脏读现象
 */
public class Demo18 {
    public static void main(String[] args) {
        MyDemo18 myDemo18 = new MyDemo18();
        MyThread18A myThread18A = new MyThread18A(myDemo18);
        myThread18A.setName("A");
        myThread18A.start();
        MyThread18B myThread18B = new MyThread18B(myDemo18);
        myThread18B.setName("B");
        myThread18B.start();
    }
}

class MyThread18A extends Thread {
    private MyDemo18 myDemo18;

    public MyThread18A(MyDemo18 myDemo18) {
        this.myDemo18 = myDemo18;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            myDemo18.myDemo18A("ThreadA:" + (i + 1));
        }
    }
}

class MyThread18B extends Thread {
    private MyDemo18 myDemo18;

    public MyThread18B(MyDemo18 myDemo18) {
        this.myDemo18 = myDemo18;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            myDemo18.myDemo18A("ThreadB:" + (i + 1));
        }
    }
}

class MyDemo18 {
    private List list = new ArrayList();

    synchronized public void myDemo18A(String username) {
        System.out.println("ThreadName set:" + Thread.currentThread().getName() + " start");
        list.add(username);
        System.out.println("ThreadName set:" + Thread.currentThread().getName() + " end");
    }

    synchronized public int getSize() {
        System.out.println("ThreadName get:" + Thread.currentThread().getName() + " start");
        int size = list.size();
        System.out.println("ThreadName get:" + Thread.currentThread().getName() + " end");
        return size;
    }
}