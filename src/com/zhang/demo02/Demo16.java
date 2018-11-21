package com.zhang.demo02;

/**
 * synchronized(非this对象)
 * 监视器必须是同一个对象，否则多线程不同步
 */
public class Demo16 {
    public static void main(String[] args) {
        MyDemo16 myDemo16 = new MyDemo16();
        MyThread16A myThread16A = new MyThread16A(myDemo16);
        myThread16A.setName("A");
        myThread16A.start();
        MyThread16B myThread16B = new MyThread16B(myDemo16);
        myThread16B.setName("B");
        myThread16B.start();
    }
}

class MyThread16A extends Thread {
    private MyDemo16 myDemo16;

    public MyThread16A(MyDemo16 myDemo16) {
        this.myDemo16 = myDemo16;
    }

    @Override
    public void run() {
        myDemo16.myDemo16("A", "AA");
    }
}

class MyThread16B extends Thread {
    private MyDemo16 myDemo16;

    public MyThread16B(MyDemo16 myDemo16) {
        this.myDemo16 = myDemo16;
    }

    @Override
    public void run() {
        myDemo16.myDemo16("B", "BB");
    }
}

class MyDemo16 {
    private String username;
    private String password;
    //private String anyString = new String();

    public void myDemo16(String usernameParam, String passwordParam) {
        try {
            String anyString = new String();
            synchronized (anyString) {
                System.out.println("ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
                username = usernameParam;
                Thread.sleep(3000);
                password = passwordParam;
                System.out.println("ThreadName:" + Thread.currentThread().getName() + " end time:" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
