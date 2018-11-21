package com.zhang.demo03;

/**
 * 使用wait()方法
 * 在没有对象监视器的情况下，即没有同步锁的情况
 * 会爆出异常
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            String str = new String("");
            str.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
