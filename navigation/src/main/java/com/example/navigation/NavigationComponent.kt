package com.example.navigation

import dagger.Component
import dagger.Provides

@Component(
    modules = [
        NavigationModule::class
    ],
    dependencies = [
        NavigationDependencies::class
    ]
)
interface NavigationComponent : NavigationApi, NavigationDependencies {

    @Component.Factory
    interface Factory {
        fun create(dependencies: NavigationDependencies): NavigationComponent
    }
}