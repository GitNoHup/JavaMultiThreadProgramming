package com.zhang.demo01;

public class Demo06 {
    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        aLogin.start();
        BLogin bLogin = new BLogin();
        bLogin.start();
    }
}

class ALogin extends Thread {
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("a", "123456");
    }
}

class BLogin extends Thread {
    @Override
    public void run() {
        super.run();
        LoginServlet.doPost("b", "456789");
    }
}

class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if ("a".equals(usernameRef)) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("UserName:" + usernameRef + "\n" + "PassWord:" + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
