package com.zhang.demo01;

public class Demo15 {
    public static void main(String[] args) {
        try {
            MyThread15 myThread15 = new MyThread15();
            myThread15.start();
            Thread.sleep(1000);
            myThread15.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}

class MyThread15 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("服务已停止！");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("如果看到这句话，代表线程没有停止！");
        } catch (InterruptedException e) {
            System.out.println("thread catch");
            e.printStackTrace();
        }
    }
}
