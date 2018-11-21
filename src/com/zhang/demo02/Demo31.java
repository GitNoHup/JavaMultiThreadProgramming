package com.zhang.demo02;

/**
 * 两个线程相互争取lock1和lock2，导致死锁
 */
public class Demo31 {
    public static void main(String[] args) {
        try {
            MyDemo31 myDemo31 = new MyDemo31();
            myDemo31.setFlag("a");
            Thread threadA = new Thread(myDemo31);
            threadA.start();
            Thread.sleep(100);//延时足够长的情况下，线程A先跑完，不会影响线程B的执行

            myDemo31.setFlag("b");
            Thread threadB = new Thread(myDemo31);
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyDemo31 implements Runnable {
    public String userName;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setFlag(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        if ("a".equals(userName)) {
            synchronized (lock1) {
                try {
                    System.out.println("userName:" + userName);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("按照lock1-》lock2的顺序执行了");
                }
            }

        }
        if ("b".equals(userName)) {
            synchronized (lock2) {
                try {
                    System.out.println("userName:" + userName);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("按照lock2-》lock1的顺序执行了");
                }
            }
        }
    }
}