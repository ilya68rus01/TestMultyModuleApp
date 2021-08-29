package ilya.khrushchev.testmultymodule.navigation

import ilya.khrushchev.core.NavCommand
import ilya.khrushchev.firstfeature.navigation.FirstFeatureNavCommandProvider
import ilya.khrushchev.testmultymodule.R
import javax.inject.Inject

class FirstFeatureNavCommandProviderImpl @Inject constructor(): FirstFeatureNavCommandProvider {
    override val toSecond = NavCommand(R.id.action_firstFragment_to_secondFragment)
    override val toThird = NavCommand(R.id.action_firstFragment_to_thirdFragment)
}
