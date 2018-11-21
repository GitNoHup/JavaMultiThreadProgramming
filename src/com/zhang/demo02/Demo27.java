package com.zhang.demo02;

/**
 * synchronized(class) 和 synchronized static方法的作用是一样的
 */
public class Demo27 {
    public static void main(String[] args) {
        MyDemo27 myDemo27 = new MyDemo27();

        MyThread27A myThread27A = new MyThread27A(myDemo27);
        myThread27A.setName("A");
        myThread27A.start();
        MyThread27B myThread27B = new MyThread27B(myDemo27);
        myThread27B.setName("B");
        myThread27B.start();
    }
}

class MyThread27A extends Thread {
    MyDemo27 myDemo27;

    public MyThread27A(MyDemo27 myDemo27) {
        this.myDemo27 = myDemo27;
    }

    @Override
    public void run() {
        myDemo27.myDemo27A();
    }
}

class MyThread27B extends Thread {
    MyDemo27 myDemo27;

    public MyThread27B(MyDemo27 myDemo27) {
        this.myDemo27 = myDemo27;
    }

    @Override
    public void run() {
        myDemo27.myDemo27B();
    }
}

class MyDemo27 {
    public void myDemo27A() {
        synchronized (MyDemo27.class) {
            try {
                System.out.println("A ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
                Thread.sleep(4000);
                System.out.println("A ThreadName:" + Thread.currentThread().getName() + "   end time:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void myDemo27B() {
        synchronized (MyDemo27.class) {
            System.out.println("B ThreadName:" + Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
            System.out.println("B ThreadName:" + Thread.currentThread().getName() + "   end time:" + System.currentTimeMillis());
        }
    }
}