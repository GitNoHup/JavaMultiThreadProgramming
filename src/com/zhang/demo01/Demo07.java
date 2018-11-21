package com.zhang.demo01;

public class Demo07 {
    public static void main(String[] args) {
        MyThread07 myThread = new MyThread07();
        Thread thread01 = new Thread(myThread);
        Thread thread02 = new Thread(myThread);
        Thread thread03 = new Thread(myThread);
        Thread thread04 = new Thread(myThread);
        Thread thread05 = new Thread(myThread);
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
    }
}

class MyThread07 extends Thread {
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        System.out.println("ThreadName:" + this.currentThread().getName() + " count=" + (count--));
    }
}