package com.zhang.demo02;

/**
 * 程序出现异常，锁被释放
 */
public class Demo09 {
    public static void main(String[] args) {
        try {
            MyDemo09 myDemo09 = new MyDemo09();
            ThreadA threadA = new ThreadA(myDemo09);
            threadA.setName("a");
            threadA.start();
            Thread.sleep(500);
            ThreadB threadB = new ThreadB(myDemo09);
            threadB.setName("b");
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    private MyDemo09 myDemo09;

    public ThreadA(MyDemo09 myDemo09) {
        this.myDemo09 = myDemo09;
    }

    @Override
    public void run() {
        myDemo09.myDemo09A();
    }
}

class ThreadB extends Thread {
    private MyDemo09 myDemo09;

    public ThreadB(MyDemo09 myDemo09) {
        this.myDemo09 = myDemo09;
    }

    @Override
    public void run() {
        myDemo09.myDemo09A();
    }
}

class MyDemo09 {
    synchronized public void myDemo09A() {
        if ("a".equals(Thread.currentThread().getName())) {
            System.out.println("ThreadName:" + Thread.currentThread().getName() + " begin:" + System.currentTimeMillis());
            while (true) {
                if ("0.123456".equals(("" + Math.random()).substring(0, 8))) {
                    System.out.println("ThreadName:" + Thread.currentThread().getName() + " exception:" + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("ThreadName B:" + Thread.currentThread().getName() + " begin:" + System.currentTimeMillis());
        }
    }
}