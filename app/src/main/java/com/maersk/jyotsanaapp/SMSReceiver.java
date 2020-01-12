package com.maersk.jyotsanaapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {
    static ReceiveMSG receiveMSG;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data = intent.getExtras();

        Object[] pdus = (Object[]) data.get("pdus");

        for (int i = 0; i < pdus.length; i++) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);

            String sender = smsMessage.getDisplayOriginatingAddress();
            //Check the sender to filter messages which we require to read
            Log.e("ReceivedMSF ", sender + "\n" + smsMessage.getMessageBody());

            if (sender.startsWith("HDFCAD")) {

                String messageBody = smsMessage.getMessageBody();

//                receiveMSG.onMessageReceived(messageBody);
            }
        }
    }


    public static void listenMessage(ReceiveMSG list){
        receiveMSG = list;
    }
}
