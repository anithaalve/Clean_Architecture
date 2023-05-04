package com.example.cleanarchitectureusingmvvm.app

import androidx.multidex.MultiDexApplication
import com.example.cleanarchitectureusingmvvm.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Main Application class.
 * Dependency Injection initiated for all sub modules.
 */
open class MainApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initiateKoin()
    }

    private fun initiateKoin() {
        startKoin{
            androidContext(this@MainApplication)
            modules(provideDependency())
        }
    }

    open fun provideDependency() = appComponent
}