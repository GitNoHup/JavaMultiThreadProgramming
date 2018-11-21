package com.zhang.demo02;

/**
 * 当其他线程执行X对象中synchronized(this)代码块时呈同步效果
 */
public class Demo23 {
    public static void main(String[] args) {
        MyObject23 myObject23 = new MyObject23();
        MyService23 myService23 = new MyService23();

        try {
            MyThread23A myThread23A = new MyThread23A(myObject23, myService23);
            myThread23A.setName("A");
            myThread23A.start();

            Thread.sleep(1000);

            MyThread23B myThread23B = new MyThread23B(myObject23);
            myThread23B.setName("B");
            myThread23B.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread23A extends Thread {
    private MyObject23 myObject23;
    private MyService23 myService23;

    public MyThread23A(MyObject23 myObject23, MyService23 myService23) {
        this.myObject23 = myObject23;
        this.myService23 = myService23;
    }

    @Override
    public void run() {
        myService23.myService(myObject23);
    }
}

class MyThread23B extends Thread {
    private MyObject23 myObject23;

    public MyThread23B(MyObject23 myObject23) {
        myObject23.myObject();
    }
}

class MyObject23 {
    public void myObject() {
        synchronized (this) {
            try {
                System.out.println("MyObject start:" + Thread.currentThread().getName() + " Time:" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("MyObject end:" + Thread.currentThread().getName() + " Time:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyService23 {
    public void myService(MyObject23 myObject23) {
        synchronized (myObject23) {
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