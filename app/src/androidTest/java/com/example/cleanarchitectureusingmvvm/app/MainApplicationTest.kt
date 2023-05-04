package com.example.cleanarchitectureusingmvvm.app

import org.koin.core.module.Module

/**
 *
 * Created by aalvekod on 24-03-2023.
 * Helps to configure required dependencies for Instru Tests.
 * Method provideDependency can be override and new dependencies can be supplied.
 * **/

class MainApplicationTest : MainApplication() {
    override fun provideDependency() = listOf<Module>()
}