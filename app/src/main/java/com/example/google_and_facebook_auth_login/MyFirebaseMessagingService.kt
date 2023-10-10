package com.example.google_and_facebook_auth_login

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        private val channelId = "my_channel_id"
        private val notificationId = 1
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("TAG", "onNewToken: Firebase :: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val data = message.data

        // Access specific values by key
        val value1 = data["title"]
        val value2 = data["body"]

        Log.e("TAG", "onMessageReceived: Firebase title:: ${message.notification?.title}")
        Log.e("TAG", "onMessageReceived: Firebase  body :: ${message.notification?.body}")
        // Log.e("TAG", "onMessageReceived: Firebase 2 :: key_value title$value1")

    }
}