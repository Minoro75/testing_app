package io.minoro75.testing_app.ui.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}