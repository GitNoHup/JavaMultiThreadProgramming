package com.zhang.demo01;

public class Demo05 {
    public static void main(String[] args) {
        MyThread05 myThread = new MyThread05();
        Thread thread01 = new Thread(myThread, "thread01");
        Thread thread02 = new Thread(myThread, "thread02");
        Thread thread03 = new Thread(myThread, "thread03");
        Thread thread04 = new Thread(myThread, "thread04");
        Thread thread05 = new Thread(myThread, "thread05");
        Thread thread06 = new Thread(myThread, "thread06");
        Thread thread07 = new Thread(myThread, "thread07");
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
        thread06.start();
        thread07.start();
    }
}

class MyThread05 extends Thread {
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("ThreadName:" + this.currentThread().getName() + " = " + count);
    }
}
