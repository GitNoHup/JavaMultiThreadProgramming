package com.zhang.demo03;

public class Demo05 {
    public static void main(String[] args) {
        Object object = new Object();
        try {
            MyThread05A myThread05A = new MyThread05A(object);
            myThread05A.start();
            Thread.sleep(1000);
            MyThread05B myThread05B = new MyThread05B(object);
            myThread05B.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyThread05A extends Thread {
    private Object object;
    MyDemo01 myDemo01 = new MyDemo01();

    public MyThread05A(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                if (myDemo01.listSize() != 5) {
                    System.out.println("wait begin");
                    object.wait();
                    System.out.println("wait end");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread05B extends Thread {
    private Object object;
    MyDemo01 myDemo01 = new MyDemo01();

    public MyThread05B(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                for (int i = 0; i < 10; i++) {
                    myDemo01.addList();
                    if (myDemo01.listSize() == 5) {
                        object.notify();
                        System.out.println("已启动");
                    }
                    System.out.println("添加了：" + myDemo01.listSize() + "个元素");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}