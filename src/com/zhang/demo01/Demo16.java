package com.zhang.demo01;

public class Demo16 {
    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread16 myThread16 = new MyThread16(object);
            myThread16.start();
            Thread.sleep(500);
            myThread16.stop();
            System.out.println("userName:" + object.getUsername());
            System.out.println("passWord:" + object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread16 extends Thread {
    private SynchronizedObject object;

    public MyThread16(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }
}

class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
