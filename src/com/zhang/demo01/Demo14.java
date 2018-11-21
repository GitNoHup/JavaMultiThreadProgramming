package com.zhang.demo01;

public class Demo14 {
    public static void main(String[] args) {
        try {
            MyThread14 myThread14 = new MyThread14();
            myThread14.start();
            Thread.sleep(1000);
            myThread14.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}

class MyThread14 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println("已停止服务！");
                break;
            }
            System.out.println("i=" + (i + 1));
        }
    }
}