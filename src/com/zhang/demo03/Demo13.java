package com.zhang.demo03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 一个生产者一个消费者，操作栈
 * @Date 2019-05-08 16:03
 * @Created Mr.zhang
 */
public class Demo13 {
    public static void main(String[] args) {
        MyDemo13 myDemo13 = new MyDemo13();
        MyThread13A myThread13A = new MyThread13A(myDemo13);
        MyThread13B myThread13B = new MyThread13B(myDemo13);
        myThread13A.start();
        myThread13B.start();
    }
}

class MyThread13A extends Thread{
    private MyDemo13 myDemo13;

    public MyThread13A(MyDemo13 myDemo13){
        this.myDemo13 = myDemo13;
    }

    @Override
    public void run() {
        while (true){
            myDemo13.push();
        }
    }
}

class MyThread13B extends Thread{
    private MyDemo13 myDemo13;

    public MyThread13B(MyDemo13 myDemo13){
        this.myDemo13 = myDemo13;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("pop："+myDemo13.pop());
        }
    }
}

class MyDemo13{
    private List list = new ArrayList();

    synchronized public void push(){
        try{
            if(list.size() == 1){
                this.wait();
            }
            list.add(Math.random());
            this.notify();
            System.out.println("push="+list.size());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public String pop(){
        String result = null;
        try{
            if(list.size() == 0){
                System.out.println("pop："+Thread.currentThread().getName()+"Waiting");
                this.wait();
            }
            result = list.get(0)+"";
            list.remove(0);
            this.notify();
            System.out.println("pop="+list.size());
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return result;
    }
}


