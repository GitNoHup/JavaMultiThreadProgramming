package com.zhang.demo02;

import java.util.ArrayList;
import java.util.List;

public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        MyDemo19 myDemo19 = new MyDemo19();
        MyThread19A myThread19A = new MyThread19A(myDemo19);
        myThread19A.setName("A");
        myThread19A.start();
        MyThread19B myThread19B = new MyThread19B(myDemo19);
        myThread19B.setName("B");
        myThread19B.start();

        Thread.sleep(5000);

        System.out.println("listSize:" + myDemo19.myDemo19B());
    }
}

class MyThread19A extends Thread {
    private MyDemo19 myDemo19;

    public MyThread19A(MyDemo19 myDemo19) {
        this.myDemo19 = myDemo19;
    }

    @Override
    public void run() {
        MyDemo19Service myDemo19Service = new MyDemo19Service();
        myDemo19Service.myDemo19(myDemo19, "A");
    }
}

class MyThread19B extends Thread {
    private MyDemo19 myDemo19;

    public MyThread19B(MyDemo19 myDemo19) {
        this.myDemo19 = myDemo19;
    }

    @Override
    public void run() {
        MyDemo19Service myDemo19Service = new MyDemo19Service();
        myDemo19Service.myDemo19(myDemo19, "B");
    }
}

class MyDemo19Service {
    public MyDemo19 myDemo19(MyDemo19 myDemo19, String data) {
        try {
            synchronized (myDemo19) {
                if (myDemo19.myDemo19B() < 1) {
                    Thread.sleep(2000);
                    myDemo19.myDemo19A(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myDemo19;
    }
}

class MyDemo19 {
    private List list = new ArrayList();

    synchronized public void myDemo19A(String data) {
        list.add(data);
    }

    synchronized public int myDemo19B() {
        return list.size();
    }
}