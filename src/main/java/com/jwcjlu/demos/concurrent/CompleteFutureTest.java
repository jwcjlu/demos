package com.jwcjlu.demos.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompleteFutureTest {
    public static void main(String[] args) {
        CompletableFuture<User> user=new CompletableFuture<User>();
        System.out.println(user.getNow(null));
        user.complete(new User("zhangsan",1));
        System.out.println(user.getNow(null));
        user.complete(new User("zhangsan",2));
        System.out.println(user.getNow(null));
    }
}
class User{
    public User(String name,int age){
        this.name=name;
        this.age=age;
    }
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
