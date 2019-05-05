package com.zhang.demo03;

/**
 * @Description notifyAll() 唤醒所有线程
 * @Date 2019-05-05 11:34
 * @Created Mr.zhang
 */
public class Demo09 {
    public static void main(String[] args) {

        try {
            Object object = new Object();
            MyThread09A myThread09A = new MyThread09A(object);
            MyThread09B myThread09B = new MyThread09B(object);
            MyThread09C myThread09C = new MyThread09C(object);

            myThread09A.start();
            myThread09B.start();

            Thread.sleep(2000);

            myThread09C.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread09A extends Thread {

    private Object object;

    public MyThread09A(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        MyDemo09 myDemo09 = new MyDemo09();
        myDemo09.service(object);
    }
}

class MyThread09B extends Thread {
    private Object object;

    public MyThread09B(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        MyDemo09 myDemo09 = new MyDemo09();
        myDemo09.service(object);
    }
}

class MyThread09C extends Thread {
    private Object object;

    public MyThread09C(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            object.notifyAll();
        }
    }
}

class MyDemo09 {
    public void service(Object object) {
        synchronized (object) {
            try {
                System.out.println("开始wait线程:" + Thread.currentThread().getName());
                object.wait();
                System.out.println("停止wait线程:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}