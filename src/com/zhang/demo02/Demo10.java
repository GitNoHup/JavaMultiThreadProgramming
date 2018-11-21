package com.zhang.demo02;

/**
 * synchronized不能继承，子类也需要加上
 */
public class Demo10 {
    public static void main(String[] args) {
        MyDemo10B myDemo10B = new MyDemo10B();
        MyThread10A myThread10A = new MyThread10A(myDemo10B);
        myThread10A.setName("A");
        myThread10A.start();
        MyThread10B myThread10B = new MyThread10B(myDemo10B);
        myThread10B.setName("B");
        myThread10B.start();
    }
}

class MyThread10A extends Thread {
    private MyDemo10B myDemo10B;

    public MyThread10A(MyDemo10B myDemo10B) {
        this.myDemo10B = myDemo10B;
    }

    @Override
    public void run() {
        myDemo10B.myDemo10();
    }
}

class MyThread10B extends Thread {
    private MyDemo10B myDemo10B;

    public MyThread10B(MyDemo10B myDemo10B) {
        this.myDemo10B = myDemo10B;
    }

    @Override
    public void run() {
        myDemo10B.myDemo10();
    }
}

class MyDemo10A {
    synchronized public void myDemo10() {
        try {
            System.out.println("ThreadName A:" + Thread.currentThread().getName() + " begin time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("ThreadName A:" + Thread.currentThread().getName() + " end time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyDemo10B extends MyDemo10A {
    @Override
    public void myDemo10() {
        try {
            System.out.println("ThreadName B:" + Thread.currentThread().getName() + " begin time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("ThreadName B:" + Thread.currentThread().getName() + " end time=" + System.currentTimeMillis());
            super.myDemo10();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}