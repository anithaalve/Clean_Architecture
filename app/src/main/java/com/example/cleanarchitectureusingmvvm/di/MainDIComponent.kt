package com.example.cleanarchitectureusingmvvm.di

/**
 * Main dependency component.
 * This will create and provide required dependencies with sub dependencies.
 */
val appComponent = listOf(UseCaseDependency, NetworkDependency, RepoDependency)