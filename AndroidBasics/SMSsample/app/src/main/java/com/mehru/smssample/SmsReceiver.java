package com.mehru.smssample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

               // Code for to receive sms
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        Object[] smsObj = (Object[]) bundle.get("pdus");

        for (Object obj : smsObj){
            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);

           String mobNo =  message.getDisplayOriginatingAddress();
           String msg = message.getDisplayMessageBody();

            Log.d("messageDetails","mob no:" + mobNo + ",msg: "+msg);


                      //Code to send sms

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("918882988023" ,null,"hello",null,null);

        }
    }
}
