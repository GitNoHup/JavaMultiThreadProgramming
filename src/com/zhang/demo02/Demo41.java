package com.zhang.demo02;

/**
 * 变量没有可视，导致线程死循环
 * 加上volalite后，变量可视，线程可以拿到正确的数据
 */
public class Demo41 {
    public static void main(String[] args) {
        try {
            MyDemo41 myDemo41 = new MyDemo41();
            MyThread41A myThread41A = new MyThread41A(myDemo41);
            myThread41A.start();

            Thread.sleep(2000);

            MyThread41B myThread41B = new MyThread41B(myDemo41);
            myThread41B.start();

            System.out.println("已经发起停止的命令了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread41A extends Thread {
    private MyDemo41 myDemo41;

    public MyThread41A(MyDemo41 myDemo41) {
        this.myDemo41 = myDemo41;
    }

    @Override
    public void run() {
        myDemo41.runThread();
    }
}

class MyThread41B extends Thread {
    private MyDemo41 myDemo41;

    public MyThread41B(MyDemo41 myDemo41) {
        this.myDemo41 = myDemo41;
    }

    @Override
    public void run() {
        myDemo41.stopThread();
    }
}

class MyDemo41 {
    volatile private boolean threadSwitch = true;

    public void runThread() {
        while (threadSwitch == true) {

        }
        System.out.println("线程停下来了！");
    }

    public void stopThread() {
        threadSwitch = false;
    }
}