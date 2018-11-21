package com.zhang.demo01;

public class Demo21 {
    public static void main(String[] args) {
        try {
            MyThread210 myThread210 = new MyThread210();
            myThread210.setPriority(Thread.NORM_PRIORITY - 3);
            myThread210.start();
            MyThread211 myThread211 = new MyThread211();
            myThread211.setPriority(Thread.NORM_PRIORITY + 3);
            myThread211.start();
            Thread.sleep(5000);
            myThread210.stop();
            myThread211.stop();
            System.out.println("myThread210:" + myThread210.getCount());
            System.out.println("myThread211:" + myThread211.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread210 extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}

class MyThread211 extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}