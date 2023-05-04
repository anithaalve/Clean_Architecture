package com.example.cleanarchitectureusingmvvm.di

/**
 * Created by aalvekod on 28-03-2023.
 * Main Koin DI component.
 * Helps to configure
 * 1) Mockwebserver
 * 2) Usecase
 * 3) Repository
 */
fun configureTestAppComponent(baseApi: String)
        = listOf(
    MockWebServerDIPTest,
    configureNetworkModuleForTest(baseApi),
    UseCaseDependency,
    RepoDependency
    )

