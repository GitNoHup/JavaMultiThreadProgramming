package com.zhang.demo02;

public class Demo36 {
    public static void main(String[] args) {
        MyDemo36 myDemo36 = new MyDemo36();
        myDemo36.printStringMethod();
        System.out.println("Stop:" + Thread.currentThread().getName());
        myDemo36.setContinuePrint(false);
    }
}

class MyDemo36 {
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
}