package com.maersk.androidmng

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.maersk.androidmng.notif.NotificationReceiver
import kotlinx.android.synthetic.main.activity_fire_base.*


class FireBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_base)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            addLatestNotification()
            notificationActions()
        }
    }


    private fun addNotification() {
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.ic_stat_bitcoin)
            .setContentTitle("Unread Message") //this is the title of notification
            .setColor(101)
            .setContentText("You have an unread message.") //this is the message showed in notification
        val intent = Intent(this, FireBaseActivity::class.java)
        val contentIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        builder.setContentIntent(contentIntent)
        // Add as notification
        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())
    }

    private fun addLatestNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mNotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(
                Constants.CHANNEL_ID,
                Constants.CHANNEL_NAME,
                importance
            )
            mChannel.description = Constants.CHANNEL_DESCRIPTION
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)
            mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            mNotificationManager.createNotificationChannel(mChannel)
        }

        /*
        * Displaying a notification locally
        */
        /*
        * Displaying a notification locally
        */MyNotificationManager.getInstance(this)
            .displayNotification("Harsha", "Hello how are you?")
    }

    fun getLaunchIntent(
        notificationId: Int,
        context: Context?
    ): PendingIntent? {
        val intent = Intent(context, RecordActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("notificationId", notificationId)
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
    }


    private fun clearNotification() {
        val notificationId = intent.getIntExtra("notificationId", 0)
        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(notificationId)
    }


    private fun notificationActions() {
        val NOTIFICATION_ID = 1
        val builder =
            NotificationCompat.Builder(this)
        builder.setSmallIcon(R.drawable.ic_stat_bitcoin)
        builder.color = ContextCompat.getColor(this, R.color.colorPrimary)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_stat_face))
        builder.setContentTitle("Notification Actions")
        builder.setContentText("Tap View to launch our website")
        builder.setAutoCancel(true)
        val launchIntent = getLaunchIntent(NOTIFICATION_ID, baseContext)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.journaldev.com"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val buttonIntent = Intent(baseContext, NotificationReceiver::class.java)
        buttonIntent.putExtra("notificationId", NOTIFICATION_ID)
        val dismissIntent =
            PendingIntent.getBroadcast(baseContext, 0, buttonIntent, 0)
        builder.setContentIntent(launchIntent)
        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent)
        builder.addAction(android.R.drawable.ic_delete, "DISMISS", dismissIntent)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // Will display the notification in the notification bar
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

}
