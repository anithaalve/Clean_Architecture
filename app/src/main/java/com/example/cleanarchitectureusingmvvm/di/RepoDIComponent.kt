package com.example.cleanarchitectureusingmvvm.di

import com.example.cleanarchitectureusingmvvm.repository.LoginRepository
import org.koin.dsl.module

/**
 * Repository DI module.
 * Provides Repo dependency.
 */
val RepoDependency = module {

    factory {
        LoginRepository()
    }

}