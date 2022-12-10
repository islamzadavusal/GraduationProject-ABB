package com.example.graduationproject.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.graduationproject.R
import com.example.graduationproject.ui.activities.LoginActivity

class MyNotificationWorker (appContext: Context, workerParameters: WorkerParameters) : Worker(appContext,workerParameters) {
    override fun doWork(): Result {
        showNotification()
        return  Result.success()
    }
    fun showNotification(){
        val builder:NotificationCompat.Builder
        val nm = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(applicationContext,LoginActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(applicationContext,0,intent,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var channel:NotificationChannel? = nm.getNotificationChannel("id")

            if(channel == null){
                channel = NotificationChannel("id","name",NotificationManager.IMPORTANCE_HIGH)
                channel.description = "description"
                nm.createNotificationChannel(channel)
            }

            builder = NotificationCompat.Builder(applicationContext,"id")
            builder.setContentTitle("Borani Restaurant")
                .setContentText("Great flavors are waiting for you!")
                .setSmallIcon(R.drawable.borani_notification)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

        }else{
            builder = NotificationCompat.Builder(applicationContext)
            builder.setContentTitle("Borani Restaurant")
                .setContentText("Great flavors are waiting for you!")
                .setSmallIcon(R.drawable.borani_notification)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .priority = Notification.PRIORITY_HIGH
        }

        nm.notify(100,builder.build())
    }
}