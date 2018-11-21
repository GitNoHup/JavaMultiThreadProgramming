package com.zhang.demo02;

public class Demo34 {
    public static void main(String[] args) {
        Outer34.Inner34A inner34A = new Outer34.Inner34A();
        Outer34.Inner34B inner34B = new Outer34.Inner34B();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner34A.methodA1(inner34B);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner34A.methodA2();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner34B.methodB1();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Outer34 {
    static class Inner34A {
        public void methodA1(Inner34B inner34B) {
            String threadName = Thread.currentThread().getName();
            synchronized (inner34B) {
                System.out.println("进入Inner34A的methodA1：" + threadName);
                for (int i = 0; i < 10; i++) {
                    System.out.println("i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("离开Inner34A的methodA1：" + threadName);
            }
        }

        public void methodA2() {
            String threadName = Thread.currentThread().getName();
            System.out.println("进入Inner34A的methodA2：" + threadName);
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("离开Inner34A的methodA2：" + threadName);
        }
    }

    static class Inner34B {
        synchronized public void methodB1() {
            String threadName = Thread.currentThread().getName();
            System.out.println("进入Inner34B的methodB1：" + threadName);
            for (int k = 0; k < 10; k++) {
                System.out.println("k=" + k);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("离开Inner34B的methodB1：" + threadName);
        }
    }
}