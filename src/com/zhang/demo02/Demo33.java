package com.zhang.demo02;

public class Demo33 {
    public static void main(String[] args) {
        MyDemo33 myDemo33 = new MyDemo33();
        myDemo33.setUsername("usernameValue");
        myDemo33.setPassword("passwordValue");
        System.out.println(myDemo33.getUsername() + " " + myDemo33.getPassword());

        MyDemo33.PrivateClass privateClass = new MyDemo33.PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
    }
}

class MyDemo33 {
    static private String username;
    static private String password;

    static class PrivateClass {
        private String age;
        private String address;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void printPublicProperty() {
            System.out.println(username + " " + password);
        }
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MyDemo33.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MyDemo33.password = password;
    }
}