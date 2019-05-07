package com.zhang.demo03;

import com.zhang.demo03.entity.ValueObject;

/**
 * @Description 一个生产者，一个消费者模式
 * 如果存在多个生产者消费者，可能导致“假死”
 * @Date 2019-05-05 15:35
 * @Created Mr.zhang
 */
public class Demo11 {
    public static void main(String[] args) {
        Object object = new Object();
        MyThread11A myThread11A = new MyThread11A(object);
        MyThread11B myThread11B = new MyThread11B(object);

        myThread11A.start();
        myThread11B.start();
    }
}

class MyThread11A extends Thread{
    private Object object;

    public MyThread11A (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            MyDemo11A myDemo11A = new MyDemo11A();
            myDemo11A.setValue(object);
        }
    }
}

class MyThread11B extends Thread{
    private Object object;

    public MyThread11B (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            MyDemo11B myDemo11B = new MyDemo11B();
            myDemo11B.getValue(object);
        }
    }
}

class MyDemo11A {

    public void setValue(Object object){
        try {
            synchronized (object) {
                if (!ValueObject.value.equals("")) {
                    object.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set的值是："+value);
                ValueObject.value = value;
                object.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyDemo11B {

    public void getValue(Object object){
        try {
            synchronized (object) {
                if (ValueObject.value.equals("")) {
                    object.wait();
                }

                System.out.println("get的值是："+ValueObject.value);
                ValueObject.value = "";
                object.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}