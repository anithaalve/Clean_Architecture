package com.example.cleanarchitectureusingmvvm.di

import okhttp3.mockwebserver.MockWebServer
import org.koin.dsl.module

/**
 * Created by aalvekod on 28-03-2023.
 * Creates Mockwebserver instance for testing
 */
val MockWebServerDIPTest = module {

    factory {
        MockWebServer()
    }

}