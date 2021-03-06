package com.zhang.demo03;

import com.zhang.demo03.entity.ValueObject;

/**
 * @Description 多生产者，多消费者
 * notify()是随机进行唤醒的
 * 解决方案，使用notifyAll()唤醒所有就不会出现假死情况了
 * 出现假死的条件，当两个消费者等待生产者生产数据，生产者1生产了数据进入waiting状态，并唤醒了生产者2
 * 这个时候生产者2判断已经有数据未消费进入waiting状态，这时所有线程都进入waiting状态
 * @Date 2019-05-05 16:52
 * @Created Mr.zhang
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread12A[] myThread12A = new MyThread12A[2];
        MyThread12B[] myThread12B = new MyThread12B[2];

        for(int i=0; i < 2; i++){
            myThread12A[i] = new MyThread12A(object);
            myThread12A[i].setName("生产者_"+(i+1));
            myThread12B[i] = new MyThread12B(object);
            myThread12B[i].setName("消费者_"+(i+1));

            myThread12A[i].start();
            myThread12B[i].start();
        }

        Thread.sleep(5000);

        /**
         * 打印执行状态
         */
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for(int i=0; i< threadArray.length; i++){
            System.out.println(threadArray[i].getName()+" "+threadArray[i].getState());
        }


    }
}

class MyThread12A extends Thread{
    private Object object;

    public MyThread12A (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            MyDemo12A myDemo12A = new MyDemo12A();
            myDemo12A.setValue(object);
        }
    }
}

class MyThread12B extends Thread{
    private Object object;

    public MyThread12B (Object object){
        this.object = object;
    }

    @Override
    public void run() {
        while (true) {
            MyDemo12B myDemo12B = new MyDemo12B();
            myDemo12B.getValue(object);
        }
    }
}

class MyDemo12A {

    public void setValue(Object object){
        try {
            synchronized (object) {
                while (!ValueObject.value.equals("")) {
                    System.out.println(Thread.currentThread().getName()+"Waiting");
                    object.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println(Thread.currentThread().getName()+"Running");
                System.out.println("set的值是："+value);
                ValueObject.value = value;
                object.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class MyDemo12B {

    public void getValue(Object object){
        try {
            synchronized (object) {
                while (ValueObject.value.equals("")) {
                    System.out.println(Thread.currentThread().getName()+"Waiting");
                    object.wait();
                }
                System.out.println(Thread.currentThread().getName()+"Running");
                System.out.println("get的值是："+ValueObject.value);
                ValueObject.value = "";
                object.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}