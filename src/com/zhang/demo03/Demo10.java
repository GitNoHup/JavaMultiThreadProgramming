package com.zhang.demo03;

/**
 * @Description wait(time) 自动唤醒
 * @Date 2019-05-05 13:37
 * @Created Mr.zhang
 */
public class Demo10 {
    public static void main(String[] args) {
        Object object = new Object();
        MyThread10A myThread10A = new MyThread10A(object);
        myThread10A.start();
    }
}

class MyThread10A extends Thread{
    private Object object;

    public MyThread10A(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                System.out.println("开始wait");
                object.wait(1000);
                System.out.println("结束wait");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
