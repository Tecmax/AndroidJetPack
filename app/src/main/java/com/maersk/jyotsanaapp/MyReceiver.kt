package com.maersk.jyotsanaapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val data = intent.extras

        val pdus = data!!["pdus"] as Array<Any>

        for (i in pdus.indices) {
            val smsMessage = SmsMessage.createFromPdu(pdus[i] as ByteArray)
            val sender = smsMessage.displayOriginatingAddress
            Log.e("ReceivedccMSF ", sender + "\n" + smsMessage.messageBody)
            if (sender.startsWith("HDFCAD")) {
                val messageBody = smsMessage.messageBody
            }
        }
    }
}
