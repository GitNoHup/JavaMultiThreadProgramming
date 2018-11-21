package com.zhang.demo01;

public class Demo08 {
    public static void main(String[] args) throws InterruptedException {
        MyThread08 myThread08 = new MyThread08();
        System.out.println(myThread08.isAlive());
        myThread08.start();
        System.out.println(myThread08.isAlive());
        Thread.sleep(1000);
        System.out.println(myThread08.isAlive());
    }
}

class MyThread08 extends Thread {
    @Override
    public void run() {
        System.out.println("run:" + this.isAlive());
    }
}
