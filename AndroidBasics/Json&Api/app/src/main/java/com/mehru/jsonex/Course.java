package com.mehru.jsonex;

import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("course_name")
    private String courseName ;

    @SerializedName("fees")
    private  int mFees ;

    public Course(String courseName, int mFees) {
        this.courseName = courseName;
        this.mFees = mFees;
    }
}
