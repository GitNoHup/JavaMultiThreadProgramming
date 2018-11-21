package com.zhang.demo01;

public class Demo18 {
    public static void main(String[] args) {
        try {
            MyDemo18 myDemo18 = new MyDemo18();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    myDemo18.printString();
                }
            };
            thread.setName("a");
            thread.start();
            Thread.sleep(1000);
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread1启动了");
                    myDemo18.printString();
                }
            };
            thread1.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyDemo18 {
    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远suspend了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
