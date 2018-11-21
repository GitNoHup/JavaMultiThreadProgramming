package com.zhang.demo01;

public class Demo09 {
    public static void main(String[] args) {
        MyThread09 myThread09 = new MyThread09();
        Thread thread = new Thread((myThread09));
        System.out.println("main:" + thread.isAlive());
        thread.setName("A");
        thread.start();
        System.out.println("main:" + thread.isAlive());
    }
}

class MyThread09 extends Thread {

    public MyThread09() {
        System.out.println("construct:" + Thread.currentThread().getName());
        System.out.println("construct:" + Thread.currentThread().isAlive());
        System.out.println("construct:" + this.getName());
        System.out.println("construct:" + this.isAlive());
    }

    @Override
    public void run() {
        System.out.println("run:" + Thread.currentThread().getName());
        System.out.println("run:" + Thread.currentThread().isAlive());
        System.out.println("run:" + this.getName());
        System.out.println("run:" + this.isAlive());
    }
}
