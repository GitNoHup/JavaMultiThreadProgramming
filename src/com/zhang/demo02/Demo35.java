package com.zhang.demo02;

public class Demo35 {
    public static void main(String[] args) {
        MyDemo35 myDemo35 = new MyDemo35();
        Userinfo userinfo = new Userinfo();

        MyThread35A myThread35A = new MyThread35A(myDemo35, userinfo);
        myThread35A.setName("A");
        myThread35A.start();

        MyThread35B myThread35B = new MyThread35B(myDemo35, userinfo);
        myThread35B.setName("B");
        myThread35B.start();
    }
}

class MyThread35A extends Thread {
    private MyDemo35 myDemo35;
    private Userinfo userinfo;

    public MyThread35A(MyDemo35 myDemo35, Userinfo userinfo) {
        this.myDemo35 = myDemo35;
        this.userinfo = userinfo;
    }

    @Override
    public void run() {
        myDemo35.myDemo35(userinfo);
    }
}

class MyThread35B extends Thread {
    private MyDemo35 myDemo35;
    private Userinfo userinfo;

    public MyThread35B(MyDemo35 myDemo35, Userinfo userinfo) {
        this.myDemo35 = myDemo35;
        this.userinfo = userinfo;
    }

    @Override
    public void run() {
        myDemo35.myDemo35(userinfo);
    }
}

class MyDemo35 {
    public void myDemo35(Userinfo userinfo) {
        synchronized (userinfo) {
            try {
                System.out.println("start:" + Thread.currentThread().getName());
                userinfo.setUserName("usernameValue");
                Thread.sleep(3000);
                System.out.println("end time:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}