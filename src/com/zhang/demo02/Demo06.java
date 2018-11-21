package com.zhang.demo02;

public class Demo06 {
    public static void main(String[] args) {
        try {
            MyDemo06 myDemo06 = new MyDemo06();
            MyThread06A myThread06A = new MyThread06A(myDemo06);
            myThread06A.start();
            Thread.sleep(200);
            myDemo06.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread06A extends Thread {
    private MyDemo06 myDemo06;

    public MyThread06A(MyDemo06 myDemo06) {
        this.myDemo06 = myDemo06;
    }

    @Override
    public void run() {
        myDemo06.setValue("B", "BB");
    }
}

class MyDemo06 {
    private String username = "A";
    private String password = "AA";

    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(2000);
            this.password = password;
            System.out.println("ThreadName:" + Thread.currentThread().getName() + " username:" + username + " password:" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void getValue() {
        System.out.println("ThreadName:" + Thread.currentThread().getName() + " username:" + username + " password:" + password);
    }
}