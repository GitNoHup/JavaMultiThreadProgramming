package com.zhang.demo01;

public class Demo12 {
    public static void main(String[] args) {
        try {
            MyThread12 myThread12 = new MyThread12();
            myThread12.start();
            Thread.sleep(500);
            myThread12.interrupt();
            System.out.println("是否停止1？=" + myThread12.interrupted());
            System.out.println("是否停止2？=" + myThread12.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
        }
    }
}

class MyThread12 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}