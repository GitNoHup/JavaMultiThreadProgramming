package com.zhang.demo01;

public class Demo19 {
    public static void main(String[] args) {
        try {
            MyThread19 myThread19 = new MyThread19();
            myThread19.start();
            Thread.sleep(1000);
            myThread19.suspend();
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread19 extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            //System.out.println(i);
        }
    }
}