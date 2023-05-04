package com.example.cleanarchitectureusingmvvm.app

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

/**
 * Created by aalvekod on 24-03-2023.
 * Custom Instrumentation Test runner.
 * Helps to configure environment with new App instance.
 */
class CustomInstrumentationRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader,
        className: String,
        context: Context
    ): Application {
        return super.newApplication(
            cl,
            MainApplicationTest::class.java.name,
            context
        )
    }
}