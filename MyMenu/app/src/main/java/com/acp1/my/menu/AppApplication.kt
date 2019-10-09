package com.acp1.my.menu

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.Stetho
import dagger.android.support.DaggerApplication
import com.acp1.my.menu.data.local.AppPreferences
import com.acp1.my.menu.presentation.di.component.DaggerAppComponent

class AppApplication : DaggerApplication() {

    val isAppInBackground: Boolean
        get() = lifecycleListener.isAppInBackground

    private val lifecycleListener: AppLifecycleListener by lazy {
        AppLifecycleListener()
    }

    init {
        instance = this
    }

    companion object {
        var instance: AppApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    private val applicationInjector = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector() = applicationInjector

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            Log.e("DEBUG", "http://localhost:8080")
            Log.e("DEBUG", "adb forward tcp:8080 tcp:8080")
            Log.e("DEBUG", "chrome://inspect")
        }

        Fresco.initialize(this)
        AppPreferences.init(this)
        setupLifecycleListener()
    }

    private fun setupLifecycleListener() {
        ProcessLifecycleOwner.get().lifecycle
            .addObserver(lifecycleListener)
    }

    class AppLifecycleListener : LifecycleObserver {

        var isAppInBackground: Boolean = false

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onMoveToForeground() {
            isAppInBackground = false
            Log.d("SampleLifecycle", "Returning to foreground…")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onMoveToBackground() {
            isAppInBackground = true
            Log.d("SampleLifecycle", "Moving to background…")
        }
    }

}
