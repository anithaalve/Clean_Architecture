package com.example.cleanarchitectureusingmvvm.di

import okhttp3.mockwebserver.MockWebServer
import org.koin.dsl.module

/**
 * Created by aalvekod on 24-03-2023.
 * Mock web server Koin DI component for Instrumentation Testing
 */
val MockWebServerInstrumentationTest = module {

    factory {
        MockWebServer()
    }

}