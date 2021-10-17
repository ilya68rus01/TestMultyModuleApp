package com.example.navigation

import com.example.moduleinjector.BaseFeatureApi
import com.example.moduleinjector.ComponentHolder
import com.example.moduleinjector.ComponentHolderDelegate
import ilya.khrushchev.core.providers.NavigationCommand

interface NavigationApi : BaseFeatureApi {
    val navigationProvider: NavigationCommand
}

object NavigationComponentHolder : ComponentHolder<NavigationApi, NavigationDependencies> {
    private val componentHolderDelegate =
        ComponentHolderDelegate<NavigationApi, NavigationDependencies, NavigationComponent> {
            dependencies -> DaggerNavigationComponent
            .factory()
            .create(dependencies)
        }

    override var dependencyProvider by componentHolderDelegate::dependencyProvider

    override fun get(): NavigationApi =
        componentHolderDelegate.get()

    internal fun getComponent(): NavigationComponent =
        componentHolderDelegate.getComponentImpl()
}