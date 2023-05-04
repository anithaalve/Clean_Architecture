package com.example.cleanarchitectureusingmvvm.di

import com.example.cleanarchitectureusingmvvm.screens.login.LoginUseCase
import org.koin.dsl.module

/**
 * Use case DI module.
 * Provide Use case dependency.
 */
val UseCaseDependency = module {

    factory {
        LoginUseCase()
    }
}