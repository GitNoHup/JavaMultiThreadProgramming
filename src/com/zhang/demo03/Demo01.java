package com.zhang.demo03;

import java.util.ArrayList;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        MyDemo01 myDemo01 = new MyDemo01();

        MyThread01A myThread01A = new MyThread01A(myDemo01);
        myThread01A.setName("A");
        myThread01A.start();

        MyThread01B myThread01B = new MyThread01B(myDemo01);
        myThread01B.setName("B");
        myThread01B.start();
    }
}

class MyThread01A extends Thread {
    private MyDemo01 myDemo01;

    public MyThread01A(MyDemo01 myDemo01) {
        this.myDemo01 = myDemo01;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                myDemo01.addList();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread01B extends Thread {
    private MyDemo01 myDemo01;

    public MyThread01B(MyDemo01 myDemo01) {
        this.myDemo01 = myDemo01;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (myDemo01.listSize() == 5) {
                    System.out.println("B线程退出");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyDemo01 {
    private List list = new ArrayList();

    public void addList() {
        list.add("张三");
    }

    public int listSize() {
        return list.size();
    }
}