package com.zhang.demo01;

public class Demo03 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
        }
    }

    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        Thread thread = new Thread(demo03);
        thread.start();
    }
}