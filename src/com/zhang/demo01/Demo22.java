package com.zhang.demo01;

public class Demo22 {
    public static void main(String[] args) {
        try {
            MyThread22 myThread22 = new MyThread22();
            myThread22.setDaemon(true);
            myThread22.start();
            Thread.sleep(5000);
            System.out.println("线程sleep，守护线程也结束了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread22 extends Thread {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}