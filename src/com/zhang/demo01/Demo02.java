package com.zhang.demo01;

public class Demo02 {
    public static void main(String[] args) {
        MyThread02 myThread02 = new MyThread02();
        myThread02.setName("myThread");
        myThread02.start();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread02 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);

                Thread.sleep(time);

                System.out.println("run=" + Thread.currentThread().getName());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
