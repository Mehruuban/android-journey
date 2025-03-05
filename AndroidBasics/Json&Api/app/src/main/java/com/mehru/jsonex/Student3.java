package com.mehru.jsonex;

import java.util.List;

public class Student3 {

    private String name ;
    private String email;
    private  int age ;

    List<Course2>list;

    public Student3(String name, String email, int age, List<Course2> list) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.list = list;
    }
}
