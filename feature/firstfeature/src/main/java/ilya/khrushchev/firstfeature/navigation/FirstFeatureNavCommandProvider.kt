package ilya.khrushchev.firstfeature.navigation

import ilya.khrushchev.core.NavCommand

interface FirstFeatureNavCommandProvider {
    val toSecond: NavCommand
    val toThird: NavCommand
}