package com.example.navigation

import com.example.moduleinjector.BaseFeatureDependencies
import ilya.khrushchev.core.providers.FirstFeatureDeps
import ilya.khrushchev.core.providers.NavigationCommand

interface NavigationDependencies : BaseFeatureDependencies {
    val navigation: NavigationCommand
}