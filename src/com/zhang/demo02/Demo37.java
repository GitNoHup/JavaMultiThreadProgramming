package com.zhang.demo02;

public class Demo37 {
    public static void main(String[] args) {
        MyDemo37 myDemo37 = new MyDemo37();
        new Thread(myDemo37, "A").start();
        System.out.println("Stop:" + Thread.currentThread().getName());
        myDemo37.setContinuePrint(false);
    }
}

class MyDemo37 implements Runnable {
    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod() {
        try {
            while (isContinuePrint == true) {
                System.out.println("ThreadName:" + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printStringMethod();
    }
}