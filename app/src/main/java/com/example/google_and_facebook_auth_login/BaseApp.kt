package com.example.google_and_facebook_auth_login

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.google.firebase.FirebaseApp

class BaseApp : Application() {

    companion object {
        private var instance: BaseApp? = null
        fun getInstance(): BaseApp? {
            if (instance == null) {
                synchronized(BaseApp::class.java) {
                    if (instance == null) {
                        instance = BaseApp()
                    }
                }
            }
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)
        FirebaseApp.initializeApp(this)
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val id = getString(R.string.virtual_tether_notification_channel_id)
            val name: CharSequence = getString(R.string.virtual_tether_notification_channel_name)
            val description = getString(R.string.virtual_tether_notification_channel_description)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance)
            channel.description = description
            val notificationManager: NotificationManager? =
                getInstance()?.applicationContext?.getSystemService(
                    NotificationManager::class.java
                )
            notificationManager?.createNotificationChannel(channel)
        }
    }
}