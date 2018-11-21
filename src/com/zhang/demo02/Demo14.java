package com.zhang.demo02;

public class Demo14 {
    public static void main(String[] args) {
        MyDemo14 myDemo14 = new MyDemo14();
        MyThread14A myThread14A = new MyThread14A(myDemo14);
        myThread14A.setName("A");
        myThread14A.start();
        MyThread14B myThread14B = new MyThread14B(myDemo14);
        myThread14B.setName("B");
        myThread14B.start();
    }
}

class MyThread14A extends Thread {
    private MyDemo14 myDemo14;

    public MyThread14A(MyDemo14 myDemo14) {
        this.myDemo14 = myDemo14;
    }

    @Override
    public void run() {
        myDemo14.myDemo14();
    }
}

class MyThread14B extends Thread {
    private MyDemo14 myDemo14;

    public MyThread14B(MyDemo14 myDemo14) {
        this.myDemo14 = myDemo14;
    }

    @Override
    public void run() {
        myDemo14.myDemo14();
    }
}

class MyDemo14 {
    public void myDemo14() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                System.out.println("ThreadNo:" + Thread.currentThread().getName() + " i=" + i);
            }
            System.out.println();
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(500);
                    System.out.println("ThreadYes:" + Thread.currentThread().getName() + " i=" + i);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}