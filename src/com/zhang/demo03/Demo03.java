package com.zhang.demo03;

/**
 * wait()获得同步锁之后才能执行成功，并将当前线程的锁释放
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            String str = new String("");
            System.out.println("syn上行");
            synchronized (str) {
                System.out.println("syn第一行");
                str.wait();
                System.out.println("wait下的代码");
            }
            System.out.println("syn下行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
