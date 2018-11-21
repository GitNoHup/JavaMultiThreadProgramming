package com.zhang.demo02;

public class Demo32 {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUserName("usernameValue");
        publicClass.setPassWord("passwordValue");
        System.out.println(publicClass.getUserName() + " " + publicClass.getPassWord());

        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
    }
}
