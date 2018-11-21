package com.zhang.demo02;

/**
 * 可重入锁
 * 包括同一个类多个方法
 * 包括父子类
 */
public class Demo08 {
    public static void main(String[] args) {
        MyThread08 myThread08 = new MyThread08();
        myThread08.start();
    }
}

class MyThread08 extends Thread {
    @Override
    public void run() {
        Son son = new Son();
        son.countSon();
    }
}

class Father {
    public int i = 10;

    synchronized public void countMain() {
        try {
            i--;
            System.out.println("father:" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Son extends Father {
    synchronized public void countSon() {
        try {
            while (i > 0) {
                i--;
                System.out.println("son:" + i);
                Thread.sleep(100);
                this.countMain();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}