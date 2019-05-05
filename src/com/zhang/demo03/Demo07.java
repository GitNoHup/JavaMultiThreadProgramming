package com.zhang.demo03;

/**
 * @Description 呈wait状态的线程被interrupt，会出现异常
 * @Date 2019-02-19 13:24
 * @Created Mr.zhang
 */
public class Demo07 {
    public static void main(String[] args) {
        try {
            Object object = new Object();
            MyThread07 myThread07 = new MyThread07(object);
            myThread07.start();
            Thread.sleep(3000);
            myThread07.interrupt();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyThread07 extends Thread {
    private Object object;

    public MyThread07 (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        MyDemo07 myDemo07 = new MyDemo07();
        myDemo07.service(object);
    }
}

class MyDemo07 {
    public void service(Object object){
        try {
            synchronized (object) {
                object.wait();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
