package com.mostafa.imani.divar

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DivarApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}