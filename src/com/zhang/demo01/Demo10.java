package com.zhang.demo01;

public class Demo10 {
    public static void main(String[] args) {
        MyThread10 myThread10 = new MyThread10();
        System.out.println(Thread.currentThread().getId());
        myThread10.start();
    }
}

class MyThread10 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(this.currentThread().getName());
            System.out.println(this.currentThread().getId());
            Thread.sleep(2000);
            System.out.println(this.currentThread().getName());
        } catch (Exception e) {

        }
    }
}