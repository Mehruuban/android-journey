package com.mehru.chatapp.Utils;

import android.content.Intent;

import com.mehru.chatapp.model.UserModel;

public class AndroidUtil {

    public static void passUserModelAsIntent (Intent intent, UserModel userModel){
        intent.putExtra("userName",userModel.getUserName());
        intent.putExtra("phoneNumber",userModel.getPhoneNumber());
        intent.putExtra("userId",userModel.getUserId());

    }

    public static  UserModel getUserModelFromIntent(Intent intent){
        UserModel userModel = new UserModel();
        userModel.setUserName(intent.getStringExtra("userName"));
        userModel.setPhoneNumber(intent.getStringExtra("phoneNumber"));
        userModel.setUserId(intent.getStringExtra("userId"));
        return userModel;

    }
}
