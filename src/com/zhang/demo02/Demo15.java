package com.zhang.demo02;

/**
 * 同一个对象，只有一个synchronized锁
 */
public class Demo15 {
    public static void main(String[] args) {
        MyDemo15 myDemo15 = new MyDemo15();
        MyThread15A myThread15A = new MyThread15A(myDemo15);
        myThread15A.setName("A");
        myThread15A.start();
        MyThread15B myThread15B = new MyThread15B(myDemo15);
        myThread15B.setName("B");
        myThread15B.start();
    }
}

class MyThread15A extends Thread {
    private MyDemo15 myDemo15;

    public MyThread15A(MyDemo15 myDemo15) {
        this.myDemo15 = myDemo15;
    }

    @Override
    public void run() {
        myDemo15.myDemo15A();
    }
}

class MyThread15B extends Thread {
    private MyDemo15 myDemo15;

    public MyThread15B(MyDemo15 myDemo15) {
        this.myDemo15 = myDemo15;
    }

    @Override
    public void run() {
        myDemo15.myDemo15B();
    }
}

class MyDemo15 {
    public void myDemo15A() {
        try {
            synchronized (this) {
                System.out.println("begin " + Thread.currentThread().getName() + " :" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end " + Thread.currentThread().getName() + " :" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void myDemo15B() {
        synchronized (this) {
            System.out.println("begin " + Thread.currentThread().getName() + " :" + System.currentTimeMillis());
            System.out.println("end " + Thread.currentThread().getName() + " :" + System.currentTimeMillis());
        }
    }
}