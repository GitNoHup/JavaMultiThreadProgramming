package com.zhang.demo01;

/**
 * yield()是放弃当前cpu资源，将它让给其他任务去占用cpu执行时间
 * 可能刚刚放弃，马上又获得cpu时间片
 */
public class Demo20 {
    public static void main(String[] args) {
        MyThread20 myThread20 = new MyThread20();
        myThread20.start();
    }
}

class MyThread20 extends Thread {
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start) + "ms");
    }
}