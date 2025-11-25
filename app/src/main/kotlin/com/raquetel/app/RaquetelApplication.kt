package com.raquetel.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RaquetelApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
    }
}
