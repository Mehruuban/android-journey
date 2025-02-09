package com.mehru.recyclerdemo;

public class item {
    String name ;
    String Email;
    int img ;

    public item(String name, String email, int img) {
        this.name = name;
        Email = email;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
