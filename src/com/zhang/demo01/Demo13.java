package com.zhang.demo01;

public class Demo13 {
    public static void main(String[] args) {
        try {
            MyThread12 myThread12 = new MyThread12();
            myThread12.start();
            Thread.sleep(1000);
            myThread12.interrupt();
            System.out.println("是否停止1？=" + myThread12.isInterrupted());
            System.out.println("是否停止2？=" + myThread12.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
        }
    }
}