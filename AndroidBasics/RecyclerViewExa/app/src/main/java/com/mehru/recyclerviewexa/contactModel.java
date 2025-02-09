package com.mehru.recyclerviewexa;

import java.util.Enumeration;

public class contactModel {
    int img;
    String name,number;
//    create a contractor
    public contactModel(int img, String name, String number){
        this.name = name;
        this.number = number;
        this.img = img;
    }

    public contactModel(String number, String name ) {
        this.number = number;
        this.name = name;
    }
}
