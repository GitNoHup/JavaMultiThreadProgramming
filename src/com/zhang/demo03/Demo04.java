package com.zhang.demo03;

/**
 * notify的特性，“执行wait方法之后”一定是最后打印
 * notify不会立即释放对象锁
 * 当执行完成当前线程，即退出synchronized代码块时才会释放锁
 * 之后myThread04A拿到锁开始执行
 */
public class Demo04 {
    public static void main(String[] args) {
        try {
            Object object = new Object();
            MyThread04A myThread04A = new MyThread04A(object);
            myThread04A.start();
            Thread.sleep(3000);
            MyThread04B myThread04B =new MyThread04B(object);
            myThread04B.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread04A extends Thread {

    private Object object;

    public MyThread04A(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                System.out.println("执行wait之前");
                object.wait();
                System.out.println("执行wait之后");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread04B extends Thread {
    private Object object;

    public MyThread04B(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("执行notify前");
            object.notify();
            System.out.println("执行notify后");
        }
    }
}