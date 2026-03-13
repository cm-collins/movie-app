package com.example.movieapp

import android.app.Application
import com.example.movieapp.movieapi.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieMainApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieMainApp)
            modules(appModule)
        }
    }

}