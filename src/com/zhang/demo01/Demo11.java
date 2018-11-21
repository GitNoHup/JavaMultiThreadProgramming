package com.zhang.demo01;

public class Demo11 {
    public static void main(String[] args) {
        try {
            MyThread11 myThread11 = new MyThread11();
            myThread11.start();
            Thread.sleep(2000);
            myThread11.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}

class MyThread11 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}