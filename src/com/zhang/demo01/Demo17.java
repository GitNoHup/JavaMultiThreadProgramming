package com.zhang.demo01;

/**
 * suspend()暂停线程
 * resume()恢复线程执行
 */
public class Demo17 {
    public static void main(String[] args) {
        try {
            MyThread17 myThread17 = new MyThread17();
            myThread17.start();
            Thread.sleep(5000);

            myThread17.suspend();
            System.out.println("A= " + System.currentTimeMillis() + " i = " + myThread17.getI());

            myThread17.resume();
            Thread.sleep(5000);

            myThread17.suspend();
            System.out.println("B= " + System.currentTimeMillis() + " i = " + myThread17.getI());
            Thread.sleep(5000);
            System.out.println("B= " + System.currentTimeMillis() + " i = " + myThread17.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread17 extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}