package com.zhang.demo02;

/**
 * synchronized(X)
 * 使用了同一个“对象监视器”
 * 所以线程同步
 */
public class Demo20 {
    public static void main(String[] args) {
        MyObjectDemo20 myObjectDemo20 = new MyObjectDemo20();
        MyServiceDemo20 myServiceDemo20 = new MyServiceDemo20();

        MyThread20A myThread20A = new MyThread20A(myObjectDemo20, myServiceDemo20);
        myThread20A.setName("A");
        myThread20A.start();
        MyThread20B myThread20B = new MyThread20B(myObjectDemo20, myServiceDemo20);
        myThread20B.setName("B");
        myThread20B.start();
    }
}

class MyThread20A extends Thread {
    private MyObjectDemo20 myObjectDemo20;
    private MyServiceDemo20 myServiceDemo20;

    public MyThread20A(MyObjectDemo20 myObjectDemo20, MyServiceDemo20 myServiceDemo20) {
        this.myObjectDemo20 = myObjectDemo20;
        this.myServiceDemo20 = myServiceDemo20;
    }

    @Override
    public void run() {
        myServiceDemo20.myService(myObjectDemo20);
    }
}

class MyThread20B extends Thread {
    private MyObjectDemo20 myObjectDemo20;
    private MyServiceDemo20 myServiceDemo20;

    public MyThread20B(MyObjectDemo20 myObjectDemo20, MyServiceDemo20 myServiceDemo20) {
        this.myObjectDemo20 = myObjectDemo20;
        this.myServiceDemo20 = myServiceDemo20;
    }

    @Override
    public void run() {
        myServiceDemo20.myService(myObjectDemo20);
    }
}

class MyServiceDemo20 {
    public void myService(MyObjectDemo20 myObjectDemo20) {
        synchronized (myObjectDemo20) {
            try {
                System.out.println("Start Time:" + System.currentTimeMillis() + " ThreadName:" + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("End Time:" + System.currentTimeMillis() + " ThreadName:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyObjectDemo20 {
}