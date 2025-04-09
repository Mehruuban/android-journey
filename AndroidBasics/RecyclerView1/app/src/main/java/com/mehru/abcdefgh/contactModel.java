package com.mehru.abcdefgh;
public class contactModel {
    int img;
    String name,number;
    //    create a contructor
    public contactModel(int img, String name, String number){
        this.name = name;
        this.number = number;
        this.img = img;
    }
    public contactModel( String name,String number){
        this.name = name;
        this.number= number;
    }

}
