package com.zhang.demo03;

/**
 * @Description notify通知线程
 * @Date 2019-02-19 15:07
 * @Created Mr.zhang
 */
public class Demo08 {
    public static void main(String[] args) {
        try {
            Object object = new Object();
            MyThread08A myThread01 = new MyThread08A(object);
            MyThread08B myThread02 = new MyThread08B(object);
            MyThread08C myThread03 = new MyThread08C(object);
            myThread01.start();
            myThread02.start();
            myThread03.start();
            Thread.sleep(2000);
            MyThread08D myThread04 = new MyThread08D(object);
            myThread04.start();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyThread08A extends Thread{
    private Object object;

    public MyThread08A (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        MyDemo08 myDemo08 = new MyDemo08();
        myDemo08.service(object);
    }
}

class MyThread08B extends Thread{
    private Object object;

    public MyThread08B (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        MyDemo08 myDemo08 = new MyDemo08();
        myDemo08.service(object);
    }
}

class MyThread08C extends Thread{
    private Object object;

    public MyThread08C (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        MyDemo08 myDemo08 = new MyDemo08();
        myDemo08.service(object);
    }
}

class MyThread08D extends Thread{
    private Object object;

    public MyThread08D (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            object.notify();
            object.notify();
            object.notify();
        }
    }
}

class MyDemo08{
    public void service(Object object){
        synchronized (object){
            try {
                object.wait();
                System.out.println("被通知的线程："+Thread.currentThread().getName());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
