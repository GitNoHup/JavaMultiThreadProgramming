package com.zhang.demo02;

/**
 * synchronized(X)
 * 使用不同“对象监视器”
 * 此时线程不同步
 */
public class Demo21 {
    public static void main(String[] args) {
        MyObjectDemo20 myObjectDemo20A = new MyObjectDemo20();
        MyObjectDemo20 myObjectDemo20B = new MyObjectDemo20();
        MyServiceDemo20 myServiceDemo20 = new MyServiceDemo20();

        MyThread20A myThread20A = new MyThread20A(myObjectDemo20A, myServiceDemo20);
        myThread20A.setName("A");
        myThread20A.start();
        MyThread20B myThread20B = new MyThread20B(myObjectDemo20B, myServiceDemo20);
        myThread20B.setName("B");
        myThread20B.start();
    }
}
