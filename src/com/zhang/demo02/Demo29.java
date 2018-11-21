package com.zhang.demo02;

/**
 * 因为Object对象不是一个，所以交替打印
 */
public class Demo29 {
    public static void main(String[] args) {
        MyDemo29 myDemo29 = new MyDemo29();

        MyThread29A myThread29A = new MyThread29A(myDemo29);
        myThread29A.setName("A");
        myThread29A.start();
        MyThread29B myThread29B = new MyThread29B(myDemo29);
        myThread29B.setName("B");
        myThread29B.start();
    }
}

class MyThread29A extends Thread {
    private MyDemo29 myDemo29;

    public MyThread29A(MyDemo29 myDemo29) {
        this.myDemo29 = myDemo29;
    }

    @Override
    public void run() {
        myDemo29.myDemo(new Object());
    }
}

class MyThread29B extends Thread {
    private MyDemo29 myDemo29;

    public MyThread29B(MyDemo29 myDemo29) {
        this.myDemo29 = myDemo29;
    }

    @Override
    public void run() {
        myDemo29.myDemo(new Object());
    }
}

class MyDemo29 {
    public void myDemo(Object object) {
        try {
            synchronized (object) {
                while (true) {
                    System.out.println("ThreadName:" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}