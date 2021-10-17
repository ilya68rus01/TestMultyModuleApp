package ilya.khrushchev.core.providers

import ilya.khrushchev.core.NavCommand

interface NavigationCommand {
    fun navigateFromFirstToSecond() : NavCommand
    fun navigateFromFirstToThird() : NavCommand
    fun navigateFromSecondToThird() : NavCommand
}