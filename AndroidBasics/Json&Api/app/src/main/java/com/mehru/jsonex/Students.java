package com.mehru.jsonex;

import com.google.gson.annotations.SerializedName;

public class Students {

    @SerializedName("name")

    private String mName ;
    @SerializedName("email")
    private  String mEmail;

    @SerializedName("age")
    private int mAge ;


    Course course;



    public Students(String mName, String mEmail, int mAge , Course course) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mAge = mAge;
        this.course = course;
    }
}
