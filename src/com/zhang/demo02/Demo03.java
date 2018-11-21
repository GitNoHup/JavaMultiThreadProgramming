package com.zhang.demo02;

/**
 * synchronized锁的是对象
 * 当new了两个HasSelfPrivateNum02的时候，线程A和线程B不冲突
 */
public class Demo03 {
    public static void main(String[] args) {
        HasSelfPrivateNum02 hasSelfPrivateNum01 = new HasSelfPrivateNum02();
        HasSelfPrivateNum02 hasSelfPrivateNum02 = new HasSelfPrivateNum02();
        MyThread02A myThread02A = new MyThread02A(hasSelfPrivateNum01);
        myThread02A.start();
        MyThread02B myThread02B = new MyThread02B(hasSelfPrivateNum02);
        myThread02B.start();
    }
}
