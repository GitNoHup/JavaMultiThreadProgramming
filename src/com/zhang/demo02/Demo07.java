package com.zhang.demo02;

/**
 * 获得对象锁后，再次请求这个对象锁是可以获得对象锁的
 */
public class Demo07 {
    public static void main(String[] args) {
        MyThread07 myThread07 = new MyThread07();
        myThread07.start();
    }
}

class MyThread07 extends Thread {
    @Override
    public void run() {
        MyDemo07 myDemo07 = new MyDemo07();
        myDemo07.service1();
    }
}

class MyDemo07 {
    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }
}