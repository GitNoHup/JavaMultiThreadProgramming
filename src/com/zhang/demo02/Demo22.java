package com.zhang.demo02;

/**
 * 对MyObject加锁，线程同步
 * 当其他线程执行X对象中synchronized方法时呈同步效果
 */
public class Demo22 {
    public static void main(String[] args) {
        MyObject22 myObject22 = new MyObject22();
        MyService22 myService22 = new MyService22();

        try {
            MyThread22A myThread22A = new MyThread22A(myObject22, myService22);
            myThread22A.setName("A");
            myThread22A.start();

            Thread.sleep(1000);

            MyThread22B myThread22B = new MyThread22B(myObject22);
            myThread22B.setName("B");
            myThread22B.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread22A extends Thread {
    private MyObject22 myObject22;
    private MyService22 myService22;

    public MyThread22A(MyObject22 myObject22, MyService22 myService22) {
        this.myObject22 = myObject22;
        this.myService22 = myService22;
    }

    @Override
    public void run() {
        myService22.myService(myObject22);
    }
}

class MyThread22B extends Thread {
    private MyObject22 myObject22;

    public MyThread22B(MyObject22 myObject22) {
        myObject22.myObject();
    }
}

class MyObject22 {
    synchronized public void myObject() {
        try {
            System.out.println("MyObject start:" + Thread.currentThread().getName() + " Time:" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("MyObject end:" + Thread.currentThread().getName() + " Time:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyService22 {
    public void myService(MyObject22 myObject22) {
        synchronized (myObject22) {
            try {
                System.out.println("MyService start:" + Thread.currentThread().getName() + " Time:" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("MyService end:" + Thread.currentThread().getName() + " Time:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}