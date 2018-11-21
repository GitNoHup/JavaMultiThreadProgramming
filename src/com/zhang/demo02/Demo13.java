package com.zhang.demo02;

public class Demo13 {
    public static void main(String[] args) {
        MyDemo13 myDemo13 = new MyDemo13();
        MyThread13A myThread13A = new MyThread13A(myDemo13);
        myThread13A.start();
        MyThread13B myThread13B = new MyThread13B(myDemo13);
        myThread13B.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = MyDemo13Util.beginTime1;
        if (MyDemo13Util.beginTime2 < MyDemo13Util.beginTime1) {
            beginTime = MyDemo13Util.beginTime2;
        }
        long endTime = MyDemo13Util.endTime1;
        if (MyDemo13Util.endTime2 > MyDemo13Util.endTime1) {
            endTime = MyDemo13Util.endTime2;
        }
        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}

class MyThread13A extends Thread {
    private MyDemo13 myDemo13;

    public MyThread13A(MyDemo13 myDemo13) {
        this.myDemo13 = myDemo13;
    }

    @Override
    public void run() {
        MyDemo13Util.beginTime1 = System.currentTimeMillis();
        myDemo13.myDemo13();
        MyDemo13Util.endTime1 = System.currentTimeMillis();
    }
}

class MyThread13B extends Thread {
    private MyDemo13 myDemo13;

    public MyThread13B(MyDemo13 myDemo13) {
        this.myDemo13 = myDemo13;
    }

    @Override
    public void run() {
        MyDemo13Util.beginTime2 = System.currentTimeMillis();
        myDemo13.myDemo13();
        MyDemo13Util.endTime2 = System.currentTimeMillis();
    }
}

class MyDemo13 {
    private String getData1;
    private String getData2;

    public void myDemo13() {
        try {
            System.out.println("begin");
            Thread.sleep(4000);
            synchronized (this) {
                getData1 = "返回值1 ThreadName:" + Thread.currentThread().getName();
                getData2 = "返回值1 ThreadName:" + Thread.currentThread().getName();
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyDemo13Util {
    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;
}