package com.zhang.demo02;

public class Demo02 {
    public static void main(String[] args) {
        HasSelfPrivateNum02 hasSelfPrivateNum = new HasSelfPrivateNum02();
        MyThread02A myThread02A = new MyThread02A(hasSelfPrivateNum);
        myThread02A.start();
        MyThread02B myThread02B = new MyThread02B(hasSelfPrivateNum);
        myThread02B.start();
    }
}

class MyThread02A extends Thread {
    private HasSelfPrivateNum02 hasSelfPrivateNum;

    public MyThread02A(HasSelfPrivateNum02 hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("a");
    }
}

class MyThread02B extends Thread {
    private HasSelfPrivateNum02 hasSelfPrivateNum;

    public MyThread02B(HasSelfPrivateNum02 hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("b");
    }
}

class HasSelfPrivateNum02 {
    private int num = 0;

    synchronized public void addI(String username) {
        try {
            if ("a".equals(username)) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num= " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}