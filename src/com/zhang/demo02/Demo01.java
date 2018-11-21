package com.zhang.demo02;

public class Demo01 {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        MyThread01A myThread01A = new MyThread01A(hasSelfPrivateNum);
        myThread01A.start();
        MyThread01B myThread01B = new MyThread01B(hasSelfPrivateNum);
        myThread01B.start();
    }
}

class MyThread01A extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;

    public MyThread01A(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("a");
    }
}

class MyThread01B extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;

    public MyThread01B(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("b");
    }
}

class HasSelfPrivateNum {
    public void addI(String username) {
        try {
            int num = 0;
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