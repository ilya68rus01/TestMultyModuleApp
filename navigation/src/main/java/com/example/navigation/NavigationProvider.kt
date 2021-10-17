package com.example.navigation

import ilya.khrushchev.core.NavCommand
import ilya.khrushchev.core.providers.NavigationCommand

class NavigationProvider : NavigationCommand {
    override fun navigateFromFirstToSecond() = NavCommand(R.id.action_firstFragment_to_secondFragment)
    override fun navigateFromFirstToThird() = NavCommand(R.id.action_firstFragment_to_thirdFragment)
    override fun navigateFromSecondToThird() = NavCommand(R.id.action_secondFragment_to_thirdFragment)
}