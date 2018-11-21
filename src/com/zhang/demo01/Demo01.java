package com.zhang.demo01;

public class Demo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread");
    }
}
