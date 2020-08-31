package com.example.postcast_reactive_mvp

import android.app.Application
import com.example.postcast_reactive_mvp.data.models.modelImpls.PodCastModelImpl

class PodCastApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PodCastModelImpl.initDatabase(applicationContext)
    }
}