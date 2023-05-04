package com.example.cleanarchitectureusingmvvm.di

/**
 * Created by aalvekod on 24-03-2023.
 * Main Koin DI component for Instrumentation Testing
 */
fun generateTestAppComponent(baseApi: String)
        = listOf(
    configureNetworkForInstrumentationTest(baseApi),
    UseCaseDependency,
    MockWebServerInstrumentationTest,
    RepoDependency
)