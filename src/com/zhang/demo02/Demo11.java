package com.zhang.demo02;

public class Demo11 {
    public static void main(String[] args) {
        MyDemo11 myDemo11 = new MyDemo11();
        MyThread11A myThread11A = new MyThread11A(myDemo11);
        myThread11A.start();
        MyThread11B myThread11B = new MyThread11B(myDemo11);
        myThread11B.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = MyDemo11Util.beginTime1;
        if (MyDemo11Util.beginTime2 < MyDemo11Util.beginTime1) {
            beginTime = MyDemo11Util.beginTime2;
        }
        long endTime = MyDemo11Util.endTime1;
        if (MyDemo11Util.endTime2 > MyDemo11Util.endTime1) {
            endTime = MyDemo11Util.endTime2;
        }
        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}

class MyThread11A extends Thread {
    private MyDemo11 myDemo11;

    public MyThread11A(MyDemo11 myDemo11) {
        this.myDemo11 = myDemo11;
    }

    @Override
    public void run() {
        MyDemo11Util.beginTime1 = System.currentTimeMillis();
        myDemo11.myDemo11();
        MyDemo11Util.endTime1 = System.currentTimeMillis();
    }
}

class MyThread11B extends Thread {
    private MyDemo11 myDemo11;

    public MyThread11B(MyDemo11 myDemo11) {
        this.myDemo11 = myDemo11;
    }

    @Override
    public void run() {
        MyDemo11Util.beginTime2 = System.currentTimeMillis();
        myDemo11.myDemo11();
        MyDemo11Util.endTime2 = System.currentTimeMillis();
    }
}

class MyDemo11 {
    private String getData1;
    private String getData2;

    synchronized public void myDemo11() {
        try {
            System.out.println("begin");
            Thread.sleep(4000);
            getData1 = "返回值1 ThreadName:" + Thread.currentThread().getName();
            getData2 = "返回值1 ThreadName:" + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyDemo11Util {
    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;
}