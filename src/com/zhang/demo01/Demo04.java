package com.zhang.demo01;

public class Demo04 {
    public static void main(String[] args) {
        Thread02 thread1 = new Thread02("Thread01");
        Thread02 thread2 = new Thread02("Thread02");
        Thread02 thread3 = new Thread02("Thread03");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Thread02 extends Thread {

    private int count = 5;

    public Thread02(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("ThreadName:" + this.getName() + " = " + count);
        }
    }
}
